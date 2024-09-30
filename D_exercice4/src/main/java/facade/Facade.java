package facade;

public class Facade {

    private String aDeviner=null;
    private StringBuilder devine=null;
    private int nbEssaisRestants;

    public static Facade instance = null;

    public synchronized static Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }

    private Facade() {}

    public void setaDeviner(String aDeviner) {
        this.aDeviner=aDeviner;
        this.devine=new StringBuilder("_".repeat(aDeviner.length()));
        this.nbEssaisRestants=10;
    }

    public String getaDeviner() {
        return aDeviner;
    }

    public StringBuilder getDevine() {
        return devine;
    }

    public void setDevine(StringBuilder devine) {
        this.devine = devine;
    }

    public int getNbEssaisRestants() {
        return nbEssaisRestants;
    }

    public void setNbEssaisRestants(int nbEssaisRestants) {
        this.nbEssaisRestants = nbEssaisRestants;
    }

    public boolean test(char carac){
        boolean res=false;
        for (int last=aDeviner.indexOf(carac);last!=-1;last=aDeviner.indexOf(carac,last+1)) {
            res = true;
            devine.setCharAt(last, carac);
        }
        if (!res) {
            nbEssaisRestants--;
        }
        return res;
    }
}
