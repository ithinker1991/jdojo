package com.ashu.lang.basic;

public class EnumDemo {
  public enum RoomSunLevel {
    LEVEL0(30_000_000L),
    LEVEL1(60_000_000L),
    LEVEL2(100_000_000L),
    LEVEL3(500_000_000L),
    LEVEL4(1_000_000_000L);

    private final Long level;
    RoomSunLevel(Long level) {
      this.level = level;
    }
    public Long getLevel() {
      return this.level;
    }
  }


  public static void main(String[] args) {
    RoomSunLevel l = RoomSunLevel.valueOf("LEVEL2");



    System.out.println(l.level);
    System.out.println(l.getLevel());
    System.out.println(l.ordinal());
  }

}
