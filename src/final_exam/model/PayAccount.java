package final_exam.model;

public class PayAccount extends BankAccount {
    private String soThe;
    private double soTienTrongTaiKhoan;

    public PayAccount( String maTaiKhoan, String tenChuNhan, String ngayTao, String soThe, double soTienTrongTaiKhoan) {
        super( maTaiKhoan, tenChuNhan, ngayTao);
        this.soThe = soThe;
        this.soTienTrongTaiKhoan = soTienTrongTaiKhoan;
    }

    public String getSoThe() {
        return soThe;
    }

    public void setSoThe(String soThe) {
        this.soThe = soThe;
    }

    public double getSoTienTrongTaiKhoan() {
        return soTienTrongTaiKhoan;
    }

    public void setSoTienTrongTaiKhoan(double soTienTrongTaiKhoan) {
        this.soTienTrongTaiKhoan = soTienTrongTaiKhoan;
    }

    @Override
    public String getInfo() {

        return String.format("%s,%s,%s,%s,%s\n",getMaTaiKhoan(),getTenChuNhan(),getNgayTao(),getSoThe(),getSoTienTrongTaiKhoan());

    }

    @Override
    public String toString() {
        return "PayAccount{" +
                "Id tai khoan= "+ getIdTaiKhoan() +
                ", Ma tai khoan= "+ getMaTaiKhoan() +
                ", Ten chu= "+ getTenChuNhan() +
                ", Ngay tao= "+ getNgayTao() +
                ", soThe='" + soThe +
                ", soTienTrongTaiKhoan=" + soTienTrongTaiKhoan +
                '}';
    }
}
