package Method;


public class MethodDosen {
    private String kode_dosen;
    private int no_hp;

    private String nama;
    private String alamat;
    private String email;
    private String password;
    private String TTL;

    public MethodDosen(String no, int no_hp, String nama, String alamat, String email, String password, String TTL) {
        this.kode_dosen = no;
        this.no_hp = no_hp;
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
        this.password = password;
        this.TTL = TTL;
    }

    public MethodDosen() {
    }
    public String getKode_dosen() {
        return kode_dosen;
    }

    /**
     * @param nim the nim to set
     */
    public void setKode_dosen(String no) {
        this.kode_dosen = no;
    }

    /**
     * @return the no_hp
     */
    public int getNo_hp() {
        return no_hp;
    }

    /**
     * @param no_hp the no_hp to set
     */
    public void setNo_hp(int no_hp) {
        this.no_hp = no_hp;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the TTL
     */
    public String getTTL() {
        return TTL;
    }

    /**
     * @param TTL the TTL to set
     */
    public void setTTL(String TTL) {
        this.TTL = TTL;
    }
}
