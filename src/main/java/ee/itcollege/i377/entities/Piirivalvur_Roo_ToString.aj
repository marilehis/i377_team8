// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.i377.entities;

import java.lang.String;

privileged aspect Piirivalvur_Roo_ToString {
    
    public String Piirivalvur.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AuastmeMuutumines: ").append(getAuastmeMuutumines() == null ? "null" : getAuastmeMuutumines().size()).append(", ");
        sb.append("Eesnimed: ").append(getEesnimed()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Isikukood: ").append(getIsikukood()).append(", ");
        sb.append("Kommentaar: ").append(getKommentaar()).append(", ");
        sb.append("Nimi: ").append(getNimi()).append(", ");
        sb.append("Perekonnanimi: ").append(getPerekonnanimi()).append(", ");
        sb.append("PiirivalvurIntsidendis: ").append(getPiirivalvurIntsidendis() == null ? "null" : getPiirivalvurIntsidendis().size()).append(", ");
        sb.append("PiirivalvurPiiripunktis: ").append(getPiirivalvurPiiripunktis() == null ? "null" : getPiirivalvurPiiripunktis().size()).append(", ");
        sb.append("PiirivalvurVaeosas: ").append(getPiirivalvurVaeosas() == null ? "null" : getPiirivalvurVaeosas().size()).append(", ");
        sb.append("PiirivalvurVodikohals: ").append(getPiirivalvurVodikohals() == null ? "null" : getPiirivalvurVodikohals().size()).append(", ");
        sb.append("PiirivalvuriKontakts: ").append(getPiirivalvuriKontakts() == null ? "null" : getPiirivalvuriKontakts().size()).append(", ");
        sb.append("SeotudKontaktisiks: ").append(getSeotudKontaktisiks() == null ? "null" : getSeotudKontaktisiks().size()).append(", ");
        sb.append("SoduriKood: ").append(getSoduriKood()).append(", ");
        sb.append("Sugu: ").append(getSugu()).append(", ");
        sb.append("VahtkonnaLiiges: ").append(getVahtkonnaLiiges() == null ? "null" : getVahtkonnaLiiges().size()).append(", ");
        sb.append("Version: ").append(getVersion());
        return sb.toString();
    }
    
}
