package bms.java.service;

public interface Host {
	/*ȸ������*/
	public void deleteMember(); // ȸ������
	public void alterMemberStat(); // ȸ������ ����
	
	/*������*/
	public void addBook(); // �����԰�
	public void editBook(); // ������������
	public void deleteBook(); // ��������
	
	/*�ֹ�����*/
	public void confirmOrder1(); // ����Ȯ��
	public void confirmOrder2(); // �߼�ó��
	public void allowRefund(); // ȯ�ҽ���
}
