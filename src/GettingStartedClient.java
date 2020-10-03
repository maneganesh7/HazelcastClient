
import java.util.Scanner;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IQueue;

public class GettingStartedClient {

	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		//clientConfig.addAddress("localhost");
		clientConfig.addAddress("10.53.16.145:5702");
		clientConfig.getGroupConfig().setName("mdmce-hazelcast-instance");

		/*Config conf = new Config();
		conf.setConfigurationFile(
				new File("C:\\Users\\GaneshMane\\Desktop\\127 env\\hazelcast-3.8.1\\bin\\hazelcast.xml"));
		Hazelcast.newHazelcastInstance(conf);*/

		HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);

		// IQueue<Object> queue =
		// client.getQueue("hazelcast:queue:DemoIncrementalIntegration?hazelcastInstance=#hazelcastInstance");

		// IQueue<Object> queue = client.getQueue("magento2IncremenatlIntegration");

		//IQueue<Object> queue = client.getQueue("magento2_connector_item_publish_queue");
		//IQueue<Object> queue = client.getQueue("google_connector_item_publish_queue");
		//IQueue<Object> queue = client.getQueue("adobe_connector_item_publish_queue");
		//IQueue<Object> queue = client.getQueue("amazon_connector_image_publish_queue");
		IQueue<Object> queue = client.getQueue("ebay_connector_item_publish_queue");
		
		// IQueue<Object> queue = client.getQueue("testVinod");

		System.out.println("Got Queue");

		System.out.println("Pollig ");
		System.out.println(queue.poll());
		System.out.println("Polled");
		/*
		 * 
		 * 
		 * { "itemId":42402,
		 * "catalogName":Variants","specMapName":"VariantToMagentoSpecMap" }
		 */

		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter next item or quit to quit");

		String line = null;
		while (!(line = scanner.nextLine()).equalsIgnoreCase("quit")) {
			queue.add(line);

			System.out.println("Element Sent on Queue");

			System.out.println("Please enter next item or quit to quit");

		}

	}
}