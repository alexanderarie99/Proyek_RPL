package Method;

public class MataKuliah {
    private int sks;
    private String kode_matkul;
    private String nama_matkul;
    private String kode_dosen;
    private String nama_dosen;

    public String getNama_dosen() {
        return nama_dosen;
    }

    public void setNama_dosen(String nama_dosen) {
        this.nama_dosen = nama_dosen;
    }

    /**
     * @return the sks
     */
    public int getSks() {
        return sks;
    }

    /**
     * @param sks the sks to set
     */
    public void setSks(int sks) {
        this.sks = sks;
    }

    /**
     * @return the kode_matkul
     */
    public String getKode_matkul() {
        return kode_matkul;
    }

    /**
     * @param kode_matkul the kode_matkul to set
     */
    public void setKode_matkul(String kode_matkul) {
        this.kode_matkul = kode_matkul;
    }

    /**
     * @return the nama_matkul
     */
    public String getNama_matkul() {
        return nama_matkul;
    }

    /**
     * @param nama_matkul the nama_matkul to set
     */
    public void setNama_matkul(String nama_matkul) {
        this.nama_matkul = nama_matkul;
    }

    public String getKode_dosen() {
        return kode_dosen;
    }

    public MataKuliah() {
    }

    public MataKuliah(int sks, String kode_matkul, String nama_matkul, String kode_dosen,String nama_dosen) {
        this.sks = sks;
        this.kode_matkul = kode_matkul;
        this.nama_matkul = nama_matkul;
        this.kode_dosen = kode_dosen;
        this.nama_dosen = nama_dosen;
    }

    /**
     * @param kode_dosen the kode_dosen to set
     */
    public void setKode_dosen(String kode_dosen) {
        this.kode_dosen = kode_dosen;
    }
}
