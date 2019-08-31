package com.calculator.aop;

import java.lang.reflect.Method;

import com.calculator.annotations.DBTransaction;
import com.calculator.annotations.TransactionType;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SessionAspect {

	@Autowired
	protected SessionFactory sessionFactory;
	
	private Session readOnlySession;
	private TransactionType type;

	@Around(value = "@annotation(com.calculator.annotations.DBTransaction)")
	public Object handleSession(ProceedingJoinPoint joinPoint) throws Throwable {
		getTransactionType(joinPoint);
		
		startTransaction();
		Object data = joinPoint.proceed();
		closeTransaction();
		return data;
	}
	private void closeTransaction() {
		if (this.type == TransactionType.READ) {
			Transaction tx = this.readOnlySession.getTransaction();
			if (tx.getStatus().equals(TransactionStatus.ACTIVE))
			{
				tx.commit();
			}
		 }
	}

	private void startTransaction() {
		if (this.type == TransactionType.READ) {
			Transaction tx = this.readOnlySession.beginTransaction();
			tx.begin();
		}
		
	}

	
	private TransactionType getTransactionType(JoinPoint joinPoint) throws NoSuchMethodException, Exception {
		Class<?> clazz = joinPoint.getTarget().getClass();
		String methodName = joinPoint.getSignature().getName();
		Object[] objects = joinPoint.getArgs();
		Class<?> args[] = new Class[objects.length];

		for (int i = 0; i < objects.length; i++) {
			args[i] = objects[i].getClass();
		}

		Method method = clazz.getMethod(methodName, args);
		if (method.isAnnotationPresent(DBTransaction.class)) {
			 this.type = method.getAnnotation(DBTransaction.class).type();
			switch (type) {
			case READ: {
				this.readOnlySession = sessionFactory.getCurrentSession();
				break;
			}
						
				default:
					throw new Exception("DBTransaction not configured properly");
			}
			return this.type;
		}
		return null;
	}


}