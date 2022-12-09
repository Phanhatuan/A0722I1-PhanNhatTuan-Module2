package final_exam.model;

public class SaveAccount extends BankAccount{
    private double tienGui;
    private String ngayGui;
    private double laiSuat;
    private int kiHan;

    public SaveAccount( String maTaiKhoan, String tenChuNhan, String ngayTao, double tienGui, String ngayGui, double laiSuat, int kiHan) {
        super(maTaiKhoan, tenChuNhan, ngayTao);
        this.tienGui = tienGui;
        this.ngayGui = ngayGui;
        this.laiSuat = laiSuat;
        this.kiHan = kiHan;
    }

    public double getTienGui() {
        return tienGui;
    }

    public void setTienGui(double tienGui) {
        this.tienGui = tienGui;
    }

    public String getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(String ngayGui) {
        this.ngayGui = ngayGui;
    }

    public double getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(double laiSuat) {
        this.laiSuat = laiSuat;
    }

    public int getKiHan() {
        return kiHan;
    }

    public void setKiHan(int kiHan) {
        this.kiHan = kiHan;
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s\n",getMaTaiKhoan(),getTenChuNhan(),getNgayTao(),getTienGui(),getNgayGui(),getLaiSuat(),getKiHan());
    }

    @Override
    public String toString() {
        return "SaveAccount{" +
                "Id tai khoan= "+ getIdTaiKhoan() +
                ", Ma tai khoan= "+ getMaTaiKhoan() +
                ", Ten chu= "+ getTenChuNhan() +
                ", Ngay tao= "+ getNgayTao() +
                ", tienGui= " + tienGui +
                ", ngayGui= " + ngayGui +
                ", laiSuat= " + laiSuat +
                ", kiHan= " + kiHan +
                '}';
    }
}
