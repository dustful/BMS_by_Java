package bms.java.service;

public interface Text {
	
	/*�޴�����*/
	public static final String MAIN_MENU = "1.�α��� 2.ȸ������ 0.�ý�������";
	public static final String HOST_MENU = "1.ȸ������ 2.������ 3.�ֹ����� 0.�α׾ƿ�";
	public static final String HOST_MEMBER_MENU = "1.ȸ������ 2.ȸ�����º��� 0.�����޴�";
	public static final String HOST_MEMBER_EDIT_MENU = "1.���� 2.Ż�� 0.���";
	public static final String HOST_BOOK_MENU = "1.�����԰� 2.������������ 3.�������� 0.�����޴�";
	public static final String HOST_BOOK_EDIT_MENU = "1.������ 2.���� 3.���ǻ� 4.���� 5.������ 6.������ 7.������ 0.���";
	public static final String HOST_ORDER_MENU = "1.����Ȯ�� 2.�߼�ó�� 3.ȯ�ҽ��� 0.�����޴�";
	public static final String GUEST_MENU = "1.�ֹ� 2.��ٱ��Ͽ��߰� 3.��ٱ��Ϻ��� 4.�ֹ�����Ȯ�� 5.ȸ��Ż�� 0.�α׾ƿ�";
	public static final String GUEST_ORDER_MENU = "1.�ֹ���� 2.ȯ�ҽ�û 0.�����޴�";
	public static final String GUEST_CART_MENU = "1.��ٱ��Ͽ������� 2.��ٱ����ֹ� 0.�����޴�";
	
	/*��Ȳ����¸޽���*/
	public static final String START_SYSTEM = "���� ���� �ý����� �����մϴ�.";
	public static final String INVALID_INPUT = "�߸��� �Է��Դϴ�.";
	
	// �α���
	public static final String INPUT_ID = "ID�� �Է��ϼ���.";
	public static final String INPUT_PW = "��й�ȣ�� �Է��ϼ���.";
	public static final String INVALID_SIGN = "��ġ�ϴ� ID�� ���ų� ��й�ȣ�� �����ϴ�.";
	public static final String SUCCEED_SIGN = "�� ȯ���մϴ�.";
	
	// �α׾ƿ�
	public static final String SIGNOUT = "������ �����մϴ�.";
	
	// ȸ������
	public static final String INPUT_REG_ID = "������ ID�� �Է��ϼ���.";
	public static final String INPUT_REG_PW = "��й�ȣ�� �Է��ϼ���.";
	public static final String INPUT_MNAME = "ȸ������ �Է��ϼ���.";
	public static final String SIGNUP_ERR_1 = "ID�� 4�� �̻� �Է��ؾ� �մϴ�.";
	public static final String SIGNUP_ERR_2 = "�̹� �����ϴ� ID�Դϴ�.";
	public static final String COMPLETE_SIGNUP = "ȸ�������� �Ϸ�Ǿ����ϴ�.";
	
	public static final String THERE_IS_NO_MEMBER = "���Ե� ȸ���� �����ϴ�.";
	public static final String THERE_IS_NO_MEMBERID = "�ش��ϴ� ȸ��ID�� �������� �ʽ��ϴ�.";
	public static final String THERE_IS_NO_BOOK = "�԰�� ������ �����ϴ�.";
	public static final String THERE_IS_NO_BOOKNO = "�ش��ϴ� ������ �������� �ʽ��ϴ�.";
	public static final String THERE_IS_NO_ORDER = "�ֹ��� ������ �����ϴ�.";
	public static final String THERE_IS_NO_ORDERNO = "�ش��ϴ� �ֹ���ȣ�� �������� �ʽ��ϴ�.";
	public static final String THERE_IS_NO_CART = "��ٱ��Ͽ� ��ǰ�� �����ϴ�.";
	public static final String QUIT_SYSTEM = "�ý����� �����մϴ�.";
	
	// ȸ������
	public static final String DELETE_MEMEBERID = "������ ȸ��ID�� �Է��ϼ���.";
	public static final String DELETE_MEMBER_ERR = "�Ǹ��ڴ� ������ �� �����ϴ�.";
	public static final String COMPLETE_DELETE_MEMBER = "�Է��� ID�� ȸ�������� �����Ǿ����ϴ�.";
	
	// ȸ������ ����
	public static final String ALTER_MEMBERID = "������ ȸ��ID�� �Է��ϼ���.";
	public static final String ALTER_MEMBER_ERR = "�Ǹ��ڴ� ������ �� �����ϴ�.";
	public static final String EDIT_STATINFO = "������ ���°��� �Է��ϼ���.";
	public static final String COMPLETE_ALTER_MEMBERSTAT = "�Է��� ID�� ȸ�������� ����Ǿ����ϴ�.";
	
	// ȸ��Ż��
	public static final String OPTOUT_MEMBER = "����������ȣ�� ���� ��й�ȣ�� �Է��ϼ���.";
	public static final String OPTOUT_MEMBER_ERR = "��й�ȣ�� ��ġ���� �ʽ��ϴ�.";
	public static final String COMPLETE_OPTOUT_MEMBER = "Ż��Ǿ����ϴ�. �׵��� �̿��� �ּż� �����մϴ�.";
	
	// �����԰�, ������������ �׸�
	public static final String BOOK_NAME = "�������� �Է��ϼ���.";
	public static final String BOOK_AUTHOR = "���ڸ� �Է��ϼ���.";
	public static final String BOOK_PUBLISHER = "���ǻ縦 �Է��ϼ���.";
	public static final String BOOK_PRICE = "������ �Է��ϼ���.";
	public static final String BOOK_QTY = "�������� �Է��ϼ���.";
	public static final String BOOK_DISCOUNT = "�������� �Է��ϼ���.";
	public static final String BOOK_MILEAGE = "�������� �Է��ϼ���.";
	
	// �����԰�
	public static final String COMPLETE_ADD_BOOK = "�����԰� �Ϸ�Ǿ����ϴ�.";
	
	// ������������
	public static final String EDIT_BOOKNO = "������ ������ȣ�� �Է��ϼ���.";
	public static final String EDIT_BOOKINFO = "������ ���������� �����ϼ���.";
	
	// ��������
	public static final String DELETE_BOOKNO = "������ ������ȣ�� �Է��ϼ���.";
	
	// �ֹ�
	public static final String ORDER_BOOKNO = "�ֹ��� ������ȣ�� �Է��ϼ���.";
	public static final String ORDER_BOOKQTY = "�ֹ������� �Է��ϼ���.";
	public static final String ORDER_INVALID_QTY = "�ֹ������� ���������� �����ϴ�.";
	public static final String CONFIRM_ORDER_MILEAGE = "������ ����Ϸ��� ������ �����ݾ��� �Է��ϼ���. ������� ���� ���, 0�� �Է��ϼ���.";
	public static final String ORDER_INVALID_MILEAGE = "�Էµ� �ݾ��� ���� �����ݺ��� �����ϴ�.";
	public static final String COMPLETE_ORDER = "�ֹ��� �Ϸ�Ǿ����ϴ�.";
	
	// �ֹ����
	public static final String CANCEL_ORDER_BOOKNO = "����� �ֹ���ȣ�� �Է��ϼ���.";
	public static final String ORDER_STAT_1 = "�ش� �ֹ����� �̹� ��ҵǾ��ų� �߼۵Ǿ� ��Ұ� �Ұ��ϹǷ� ȯ�ҿ�û�� �������ֽñ� �ٶ��ϴ�.";
	public static final String COMPLETE_CANCEL_ORDER = "�ֹ��� �ּҵǾ����ϴ�.";
	
	// ȯ�ҿ�û
	public static final String REQUEST_REFUNDNO = "ȯ�ҿ�û�� �ֹ���ȣ�� �Է��ϼ���.";
	public static final String ORDER_STAT_2 = "�ش� �ֹ����� ȯ�ҿ�û�� �Ұ��մϴ�.";
	public static final String COMPLETE_REQUEST_REFUND = "ȯ�ҿ�û�� �Ϸ������� ������ ���� ������Դϴ�.";
	
	// ����Ȯ��
	public static final String CONFIRM_ORDERNO_1 = "����Ȯ���� �ֹ���ȣ�� �Է��ϼ���.";
	public static final String ORDER_STAT_3 = "�ش� �ֹ����� ������ �Ϸ���� �ʾҰų� �̹� ����Ȯ���� �ֹ��Դϴ�.";
	
	// �߼�ó��
	public static final String CONFIRM_ORDERNO_2 = "�߼�ó���� �ֹ���ȣ�� �Է��ϼ���.";
	public static final String ORDER_STAT_4 = "�ش� �ֹ����� ����Ȯ�ε��� �ʾҰų� �̹� �߼�ó���� �ֹ��Դϴ�.";
	
	// ȯ�ҽ���
	public static final String ALLOW_REFUNDNO = "ȯ�ҽ����� �ֹ���ȣ�� �Է��ϼ���.";
	public static final String ORDER_STAT_5 = "�ش� �ֹ����� ȯ�ҿ�û�� �ֹ��� �ƴմϴ�.";
	
	// ��ٱ��Ͽ� �߰�
	public static final String ADD_CART_BOOKNO = "��ٱ��Ͽ� �߰��� ������ȣ�� �Է��ϼ���.";
	public static final String ADD_CART_CQTY = "��ٱ��Ͽ� �߰��� ������ ������ �Է��ϼ���.";
	public static final String CART_INVALID_QTY = "��ٱ��Ͽ� �߰��Ϸ��� ������ ���������� �����ϴ�.";
	public static final String COMPLETE_ADD_CART = "������ ������ ��ٱ��Ͽ� �߰��߽��ϴ�.";
	
	// ��ٱ��Ͽ��� ����
	public static final String DELETE_CART_BOOKNO = "��ٱ��Ͽ��� ������ ������ȣ�� �Է��ϼ���.";
	public static final String COMPLETE_DELETE_CART = "������ ������ ��ٱ��Ͽ��� �����߽��ϴ�.";
	
}
