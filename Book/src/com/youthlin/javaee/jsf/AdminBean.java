package com.youthlin.javaee.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.Logger;

@ManagedBean
@SessionScoped
public class AdminBean {
	private String username;
	private String password;
	private String msg;
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	private static Logger LOG = MyLog.getLogger(AdminBean.class);

	public String login() {

		msg = "";
		if ("lin".equals(getUsername()) && "1234".equals(getPassword())) {
			FacesContext.getCurrentInstance().getExternalContext()
					.getSession(true);
			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().put("login", this);
			// ��¼������һ
			BookUtil.addCount();
			int count = BookUtil.getLoginCount();
			LOG.debug("��¼�ɹ�,����¼" + count + "��");
			setCount(count);
			return "success";
		}
		msg = "�û������������";
		LOG.debug("��¼ʧ��");
		return "login";
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.put("login", null);
		return "login";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
