package com.youthlin.javaee.jsf;

/**
 * Created by lin on 2016-05-09-009. ���༰�ӷ���
 */
public enum TYPE {
	INVALID("��ѡ�����"), COMPUTER("�����"), LITERATURE("��ѧ"), MANAGEMENT("����"), OTHER(
			"����");

	public String displayName;

	TYPE(String name) {
		this.displayName = name;
	}

	public String getDisplayName() {
		return displayName;
	}

}
