public class branch {
    private String location;
    private boolean mainBuilding;
    private int floors;
    private String managerName;
    private boolean vip;

    public branch(String location, boolean mainBuilding, int floors, String managerName, boolean vip) {
        this.location = location;
        this.mainBuilding = mainBuilding;
        this.floors = floors;
        this.managerName = managerName;
        this.vip = vip;
    }

    public branch() {
        this("default location", false, 1, "default manager", false);
    }

    public String getLocation() { return location; }

    public void setLocation(String location) {
        if (location != null && !location.trim().isEmpty()) this.location = location;
    }

    public boolean isMain_building() { return mainBuilding; }

    public void setMain_building(boolean mainBuilding) { this.mainBuilding = mainBuilding; }

    public int getFloors() { return floors; }

    public void setFloors(int floors) {
        if (floors > 0) this.floors = floors;
    }

    public String getManager_name() { return managerName; }

    public void setManager_name(String managerName) {
        if (managerName != null && !managerName.trim().isEmpty()) this.managerName = managerName;
    }

    public boolean isVip() { return vip; }

    public void setVip(boolean vip) { this.vip = vip; }

    // Simple capacity check (used in your old main)
    public boolean space(int currentMembers) {
        // Example: each floor can support 50 members
        int capacity = floors * 50;
        return currentMembers > capacity; // true means overcrowded
    }

    @Override
    public String toString() {
        return "Branch{" +
                "location='" + location + '\'' +
                ", mainBuilding=" + mainBuilding +
                ", floors=" + floors +
                ", managerName='" + managerName + '\'' +
                ", vip=" + vip +
                '}';
    }
}
