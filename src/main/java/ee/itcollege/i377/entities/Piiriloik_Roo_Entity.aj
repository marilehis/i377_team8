// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.i377.entities;

import ee.itcollege.i377.entities.Piiriloik;
import java.lang.Long;

privileged aspect Piiriloik_Roo_Entity {
    
    public static Piiriloik Piiriloik.findPiiriloik(Long id) {
        if (id == null) return null;
        return entityManager().find(Piiriloik.class, id);
    }
    
}
