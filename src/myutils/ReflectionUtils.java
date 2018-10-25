package myutils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ReflectionUtils {
	public static Class getSuperClassGenricType(Class clazz, int index) {
		Type genType = clazz.getGenericSuperclass();
		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		} else {
			Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
			return index < params.length && index >= 0
					? (!(params[index] instanceof Class) ? Object.class : (Class) params[index])
					: Object.class;
		}
	}

	public static <T> Class<T> getSuperGenericType(Class clazz) {
		return getSuperClassGenricType(clazz, 0);
	}

	public static Method getDeclaredMethod(Object object, String methodName, Class<?>[] parameterTypes) {
		Class superClass = object.getClass();

		while (superClass != Object.class) {
			try {
				return superClass.getDeclaredMethod(methodName, parameterTypes);
			} catch (NoSuchMethodException arg4) {
				superClass = superClass.getSuperclass();
			}
		}

		return null;
	}

	public static void makeAccessible(Field field) {
		if (!Modifier.isPublic(field.getModifiers())) {
			field.setAccessible(true);
		}

	}

	public static Field getDeclaredField(Object object, String filedName) {
		Class superClass = object.getClass();

		while (superClass != Object.class) {
			try {
				return superClass.getDeclaredField(filedName);
			} catch (NoSuchFieldException arg3) {
				superClass = superClass.getSuperclass();
			}
		}

		return null;
	}

	public static Object invokeMethod(Object object, String methodName, Class<?>[] parameterTypes, Object[] parameters)
			throws InvocationTargetException {
		Method method = getDeclaredMethod(object, methodName, parameterTypes);
		if (method == null) {
			throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + object + "]");
		} else {
			method.setAccessible(true);

			try {
				return method.invoke(object, parameters);
			} catch (IllegalAccessException arg5) {
				System.out.println("�������׳����쳣");
				return null;
			}
		}
	}

	public static void setFieldValue(Object object, String fieldName, Object value) {
		Field field = getDeclaredField(object, fieldName);
		if (field == null) {
			throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + object + "]");
		} else {
			makeAccessible(field);

			try {
				field.set(object, value);
			} catch (IllegalAccessException arg4) {
				System.out.println("�������׳����쳣");
			}

		}
	}

	public static Object getFieldValue(Object object, String fieldName) {
		Field field = getDeclaredField(object, fieldName);
		if (field == null) {
			throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + object + "]");
		} else {
			makeAccessible(field);
			Object result = null;

			try {
				result = field.get(object);
			} catch (IllegalAccessException arg4) {
				System.out.println("�������׳����쳣");
			}

			return result;
		}
	}
}
