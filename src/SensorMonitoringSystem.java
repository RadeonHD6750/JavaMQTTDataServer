
/*
*   2024-01-29
*   JAVA MQTT
*
*   서지민
*
* */

public class SensorMonitoringSystem {
    public static void main(String[] args) {
        System.out.println("센서 모니터링 시스템");

        SensorMonitoring sensorMonitoring = new SensorMonitoring("tcp://nextit.or.kr:21883", "java");

        sensorMonitoring.connect();

        long start = System.currentTimeMillis();
        long now = 0;
        long delta = 0;

        int waitForConnectedCount = 0;
        while (!sensorMonitoring.isConnected())
        {
            now = System.currentTimeMillis();
            delta = now - start;

            if(delta % 1000 == 0)
            {
                System.out.println("연결 대기중 " + (delta / 1000) + "초");
            }
        }
        System.out.println("연결 완료 " + delta + "ms 소요");
        
        sensorMonitoring.subscribe("/chat/#", 0);
    }
}
