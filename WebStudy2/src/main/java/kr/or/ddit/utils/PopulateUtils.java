package kr.or.ddit.utils;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.AbstractConverter;

import kr.or.ddit.vo.MemberVO;

public class PopulateUtils {
	static {
		AbstractConverter converter = new AbstractConverter() {

			@Override
			protected <T> T convertToType(Class<T> type, Object value) throws Throwable {
				if (value == null || value.toString().isEmpty())
					return null;
				else
					return (T) type.getDeclaredMethod("parse", CharSequence.class).invoke(null, value.toString()); //첫번째 파라미터 : static으로, 호출자가 없어도 사용할 수 있는 클래스라는 뜻으로 null
//					return (T) LocalDateTime.parse(value.toString());
//					return (T) LocalDate.parse(value.toString());
			}

			@Override
			protected Class<?> getDefaultType() {
				return LocalDate.class;
			}
		};
		ConvertUtils.register(converter, LocalDate.class);
		ConvertUtils.register(converter, LocalDateTime.class);
	}

	public static <T> void populate(T bean, Map<String, ? extends Object> parameterMap) {
		try {
			BeanUtils.populate(bean, parameterMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
}
