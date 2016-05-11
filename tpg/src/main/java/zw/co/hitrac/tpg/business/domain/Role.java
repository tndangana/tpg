package zw.co.hitrac.tpg.business.domain;


/**
 *
 * @author tonderai ndangana
 *  created 26/04/2016
 */
public enum Role {
     
    
    ADMINISTRATOR("Adminstrator"),
    TEACHER("Teachher"),
    STUDENT("Student")             ;
    
    private final String roleName;
    
    private Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    @Override
    public String toString() {
        return roleName;
    }
    
}
