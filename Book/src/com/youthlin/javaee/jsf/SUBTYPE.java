package com.youthlin.javaee.jsf;

public enum SUBTYPE {
	INVALID("��ѡ���������"),

	COMPUTER_SOFTWARE_ENGINEERING("�������"), COMPUTER_NETWORK("���������"), COMPUTER_PROGRAM_LANGUAGE(
			"�������"), COMPUTER_OTHER("�����-����"),

	LITERATURE_STORY("С˵"), LITERATURE_ESSAY("ɢ��"), LITERATURE_POETRY("ʫ��"), LITERATURE_OTHER(
			"��ѧ-����"),

	MANAGEMENT_ADMINISTRATION("��������"), MANAGEMENT_BUSINESS_ADMINISTRATION(
			"���̹���"), MANAGEMENT_FINANCIAL("���ڹ���"), MANAGEMENT_OTHER("����-����"),

	OTHER_NONE("��");

	String displayName;

	SUBTYPE(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

}
