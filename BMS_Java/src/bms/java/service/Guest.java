package bms.java.service;

public interface Guest {
	
	/*��������*/
	public void optOut(); // ȸ��Ż��
	
	/*�ֹ�*/
	public void orderBook(); // �ֹ�
	
	/*��ٱ���*/
	public void addCart(); // ��ٱ��Ͽ� �߰�
	public void deleteCart(); // ��ٱ��Ͽ��� ����
	public void orderCart(); // ��ٱ��� �ֹ�
	
	/*�ֹ�����Ȯ��*/
	public void cancelOrder(); // �ֹ����
	public void requestRefund(); // ȯ�ҿ�û

}
