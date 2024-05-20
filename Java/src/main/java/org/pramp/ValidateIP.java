package org.pramp;

public class ValidateIP {
    static boolean validateIP(String ip) {
        /**
         ip = '192.168.0.1'
         output: true


         */
        if (ip == "") {
            return false;
        }
        String[] ipPartitions = ip.split("\\.");
        if (ipPartitions.length != 4) {
            return false;
        }
        for (String part : ipPartitions) {
            System.out.print("part" + part + " ");
            System.out.println();
            Long val;
            try {
                val = Long.parseLong(part);
            } catch (Exception e) {
                return false;
            }
            System.out.println("val" + val + " ");
            if (val > 255) {
                return false;
            }
            if (val < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validateIP("192.168.0.1"));
    }
}
