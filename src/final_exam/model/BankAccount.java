package final_exam.model;

public abstract class BankAccount {
    private static int idOrder = 0;
    private int idTaiKhoan;
    private String maTaiKhoan;
    private String tenChuNhan;
    private String ngayTao;

    public static int getIdOrder() {
        return idOrder;
    }

    public static void setIdOrder(int idOrder) {
        BankAccount.idOrder = idOrder;
    }

    public int getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(int idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getTenChuNhan() {
        return tenChuNhan;
    }

    public void setTenChuNhan(String tenChuNhan) {
        this.tenChuNhan = tenChuNhan;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public BankAccount( String maTaiKhoan, String tenChuNhan, String ngayTao) {
        this.idTaiKhoan = idOrder++;
        this.maTaiKhoan = maTaiKhoan;
        this.tenChuNhan = tenChuNhan;
        this.ngayTao = ngayTao;
    }
    public abstract String getInfo();
}
