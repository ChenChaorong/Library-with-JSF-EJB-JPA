package com.youthlin.javaee.jsf;

import java.util.*;

import javax.naming.*;

import org.apache.logging.log4j.Logger;

import com.youthlin.javaee.ejb.*;

public class BookUtil {
	static AllBookRemote allBookRemote;
	static ViewBookRemote viewBookRemote;
	static BookListRemote bookListRemote;
	static LoginCountRemote loginCountRemote;
	private static Logger LOG = MyLog.getLogger(BookUtil.class);

	public static Object getRemote(Class<?> clazz) {
//		LOG.debug("��ȡԶ�̶���");
		if (clazz.getName().equals(AllBookRemote.class.getName())
				&& allBookRemote != null) {
//			LOG.debug("AllBookRemote ��Ϊ�գ�ֱ�ӷ���");
			return allBookRemote;
		}
		if (clazz.getName().equals(ViewBookRemote.class.getName())
				&& viewBookRemote != null) {
//			LOG.debug("ViewBookRemote ��Ϊ�գ�ֱ�ӷ���");
			return viewBookRemote;
		}
		if (clazz.getName().equals(LoginCountRemote.class.getName())
				&& loginCountRemote != null) {
//			LOG.debug("LookCountRemote ��Ϊ�գ�ֱ�ӷ���");
			return loginCountRemote;
		}
		if (clazz.getName().equals(BookListRemote.class.getName())
				&& bookListRemote != null) {
//			LOG.debug("BookListRemote ��Ϊ�գ�ֱ�ӷ���");
			return bookListRemote;
		}
		Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES,
				"org.jboss.ejb.client.naming");
		try {
			Context context = new InitialContext(jndiProperties);
			final String appName = "";
			final String moduleName = "BookEJB";
			final String distinctName = "";
			final String fullName = "ejb:" + appName + "/" + moduleName
					+ "/" + distinctName + "/"
					+ clazz.getSimpleName().substring(0,
							clazz.getSimpleName().length() - 6) + "!"
					+ clazz.getName();
			LOG.debug("EJBȫ��=" + fullName);
			return context.lookup(fullName);
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			LOG.debug("Զ�̶����ȡ���");
		}
		LOG.debug("��ȡԶ�̶���ʧ��");
		return null;
	}

	/**
	 * �������е�ͼ��(Ҫ��һ����������ͼ��)
	 */
	public static List<Map<String, Object>> getAllBook() {
		allBookRemote = (AllBookRemote) getRemote(AllBookRemote.class);
		if (allBookRemote != null) {
			return allBookRemote.getAllBook();
		}
		return null;
	}

	/**
	 * ��ӵ��Ự�б���(Ҫ���������״̬�ỰBean������ʱ�б�)
	 */
	public static boolean addBook(Map<String, Object> map) {
		bookListRemote = (BookListRemote) getRemote(BookListRemote.class);
		if (bookListRemote != null) {
			LOG.debug("������ӵ��Ự�б�ķ���,��ǰ�б�=" + bookListRemote.getList());
			boolean result = bookListRemote.add(map);
			LOG.debug("��ӳɹ�=" + result + ";��ǰ�б�=" + bookListRemote.getList());
			return result;
		}
		return false;
	}

	public static List<Map<String, Object>> getList() {
		bookListRemote = (BookListRemote) getRemote(BookListRemote.class);
		if (bookListRemote != null) {
			return bookListRemote.getList();
		}
		return null;
	}

	/**
	 * ��ӻỰ�е�ͼ���б�(Ҫ�������״̬�ỰBean��һ�����һ���б�)
	 */
	public static boolean addAll(List<Map<String, Object>> list) {
		allBookRemote = (AllBookRemote) getRemote(AllBookRemote.class);
		if (allBookRemote != null) {
			LOG.debug("������������б�ķ���,ȫ���б�=" + allBookRemote.getAllBook());
			boolean result = allBookRemote.addBook(list);
			LOG.debug("��ӳɹ�=" + result + "ȫ���б�=" + allBookRemote.getAllBook());
			return result;
		}
		return false;
	}

	/**
	 * ��ѯ��¼����(Ҫ����������Bean��¼��¼����)
	 */
	public static int getLoginCount() {
		loginCountRemote = (LoginCountRemote) getRemote(LoginCountRemote.class);
		if (loginCountRemote != null) {
			return loginCountRemote.getCount();
		}
		return 0;
	}

	public static void addCount() {
		loginCountRemote = (LoginCountRemote) getRemote(LoginCountRemote.class);
		if (loginCountRemote != null) {
			loginCountRemote.add();
		}
	}

	public static void clearList() {
		bookListRemote = (BookListRemote) getRemote(BookListRemote.class);
		if (bookListRemote != null) {
			LOG.debug("��ջỰ�б�");
			bookListRemote.clear();
		}
	}

	public static void clearAll() {
		allBookRemote = (AllBookRemote) getRemote(AllBookRemote.class);
		if (allBookRemote != null) {
			LOG.debug("������У�");
			allBookRemote.clear();
		}
	}
}
