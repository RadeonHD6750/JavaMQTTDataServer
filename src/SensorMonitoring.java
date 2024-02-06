import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.Timer;
import java.util.TimerTask;

//센서 모니터링용
public class SensorMonitoring implements MqttCallback {

    private MQTTClient client;
    private String broker;
    private String clientID;


    public SensorMonitoring(String broker, String clientID)
    {
        client = new MQTTClient(this, broker, clientID);
        System.out.println("MQTT 클라이언트 생성완료");
    }

    public boolean isConnected()
    {
        return client.isConnected();
    }

    public void connect()
    {
        client.connect();
    }

    public void subscribe(String topic, int qos)
    {
        client.subscribe(topic, qos);
        System.out.println(topic + " 구독완료");
    }

    @Override
    public void connectionLost(Throwable throwable) {

    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        System.out.println("Message arrived : " + new String(mqttMessage.getPayload(), "UTF-8"));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
