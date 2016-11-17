package Method;

public class MethodKrs {
    private String kode_matkul;
    private int nim;
    private boolean status;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public MethodKrs() {
    }

    public MethodKrs(String kode_matkul, int nim) {
        this.kode_matkul = kode_matkul;
        this.nim = nim;
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
     * @return the nim
     */
    public int getNim() {
        return nim;
    }

    /**
     * @param nim the nim to set
     */
    public void setNim(int nim) {
        this.nim = nim;
    }
}
