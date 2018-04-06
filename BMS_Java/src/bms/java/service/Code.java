package bms.java.service;

public interface Code {
	
	public static final int MAIN_MENU = 0; // �� �޴�
	public static final int SIGNIN = 91; // �α���
	public static final int SIGNOUT = 92; // �α׾ƿ�
	public static final int SIGNUP = 93; // ȸ������
	public static final int OPTOUT = 94; // ȸ��Ż��

	public static final int HOST_MENU = 1; // �Ǹ��� �޴�
	public static final int HOST_MEMBER_MENU = 11; // ȸ������ �޴�
	public static final int HOST_MEMBER_1 = 111; // ȸ������
	public static final int HOST_MEMBER_2 = 112; // ȸ������ ����
	public static final int HOST_BOOK_MENU = 12; // ������ �޴�
	public static final int HOST_BOOK_1 = 121; // �����԰�
	public static final int HOST_BOOK_2 = 122; // ������������
	public static final int HOST_BOOK_3 = 123; // ��������
	public static final int HOST_ORDER_MENU = 13; // �ֹ����� �޴�
	public static final int HOST_ORDER_1 = 131; // ����Ȯ��
	public static final int HOST_ORDER_2 = 132; // �߼�ó��
	public static final int HOST_ORDER_3 = 133; // ȯ�ҽ���
	
	public static final int GUEST_MENU = 2; // ������ �޴�
	public static final int GUEST_ORDER = 21; // �ֹ�
	public static final int GUEST_ADD_CART = 22; // ��ٱ��Ͽ� �߰�
	public static final int GUEST_CART_MENU = 23; // ��ٱ��� ���� �޴�
	public static final int GUEST_CART_1 = 231; // ��ٱ��Ͽ��� ����
	public static final int GUEST_CART_2 = 232; // ��ٱ��� �ֹ�
	public static final int GUEST_ORDER_MENU = 24; // �ֹ�����Ȯ�� �޴�
	public static final int GUEST_ORDER_1 = 241; // �ֹ����
	public static final int GUEST_ORDER_2 = 242; // ȯ�ҽ�û

}
