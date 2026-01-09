public class branch {
    private String location;
    private boolean main_building;
    private int floors;
    private String manager_name;
    private boolean vip;

    public branch(String location, boolean main_building, int floors, String manager_name, boolean vip) {
        this.location = location;
        this.main_building = main_building;
        this.floors = floors;
        this.manager_name = manager_name;
        this.vip = vip;
    }
    public branch() {
        this.location = "default location";
        this.main_building = false;
        this.floors = 1;
        this.manager_name = "default name";
        this.vip = false;
    }


    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        if (location != null && !location.trim().isEmpty()) {
            this.location = location;
        } else {
            System.out.println("Warning: location cannot be empty!");
        }
    }

    public boolean isMain_building() {
        return main_building;
    }

    public void setMain_building(boolean main_building) {
        this.main_building = main_building;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
       if (floors>0){
           this.floors = floors;
       }
       else{
           System.out.println("Warning: floors cannot be negative or 0! Setting to 1.");
           this.floors =1;
       }
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        if (manager_name != null && !manager_name.trim().isEmpty()) {
            this.manager_name = manager_name;
        } else {
            System.out.println("Warning: Name cannot be empty!");
        }
    }

    public float pricelist(boolean discount){
        boolean main_br = main_building;
        float def_price = 15000;

        if (main_br){
            def_price *=2;
        }
        if (discount){
            def_price *= 0.75f;
        }
        if (vip){
            def_price*=1.5f;
        }
        return def_price;
    }

    public boolean space(int people){
        int max = 15;
        boolean is_overcrowded = false;
        if (people>max){
            is_overcrowded = true;
        }
        return is_overcrowded;
    }

    @Override
    public String toString() {
        return "Member{" +
                "manager_name=" + manager_name + '\'' +
                ", location=" + location +
                ", floors='" + floors + '\'' +
                ", main_building=" + main_building + '\'' +
                ", is_vip=" + vip + '\'' +
                '}';
    }
}
