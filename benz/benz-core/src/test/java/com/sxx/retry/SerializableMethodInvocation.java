package com.sxx.retry;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Method;

public class SerializableMethodInvocation implements Serializable {

	private static final long serialVersionUID = 6631604036553063657L;
    private Method method;
    private Object[] arguments;

    public SerializableMethodInvocation(Method method, Object[] arguments) {
        this.method = method;
        this.arguments = arguments;
    }

    public SerializableMethodInvocation() {
    }

    public Method getMethod() {
        return method;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(method.getDeclaringClass());
        out.writeUTF(method.getName());
        out.writeObject(method.getParameterTypes());
        out.writeObject(arguments);
    }
    
    public void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        Class<?> declaringClass = (Class<?>) in.readObject();
        String methodName = in.readUTF();
        Class<?>[] parameterTypes = (Class<?>[]) in.readObject();
        arguments = (Object[]) in.readObject();
        try {
            method = declaringClass.getMethod(methodName, parameterTypes);
        } catch (Throwable e) {
            throw new IOException(String.format("Error occurred resolving deserialized method '%s.%s'", declaringClass.getSimpleName(), methodName), e);
        }
    }
}
