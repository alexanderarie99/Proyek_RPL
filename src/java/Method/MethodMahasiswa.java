package Method;
public class MethodMahasiswa {
    private int nim;
    private int no_hp;
    private String nama;
    private String alamat;
    private String email;
    private String password;
    private String TTL;
    
    public MethodMahasiswa() {
    }
    public MethodMahasiswa(int nim, String nama, String alamat, String email, 
            int no_hp, String password, String TTL) {
        this.nim = nim;
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
        this.no_hp = no_hp;
        this.password = password;
        this.TTL = TTL;
    }
    public int getNim() {
        return nim;
    }
    public void setNim(int nim) {
        this.nim = nim;
    }
    public int getNo_hp() {
        return no_hp;
    }
    public void setNo_hp(int no_hp) {
        this.no_hp = no_hp;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getTTL() {
        return TTL;
    }
    public void setTTL(String TTL) {
        this.TTL = TTL;
    }
}
