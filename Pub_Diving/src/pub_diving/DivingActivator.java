package pub_diving;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class DivingActivator implements BundleActivator {
	ServiceRegistration publisherServiceRegistration;

	public void start(BundleContext context) throws Exception {
		
		// start method for the Diving Publisher
			System.out.println("Diving Publisher has Started.");

			DivingPublisher DivingPublisher = new DivingPubImpl();

			// Register service 
			publisherServiceRegistration = context.registerService(DivingPublisher.class.getName(),
					DivingPublisher, null);
	}


	public void stop(BundleContext context) throws Exception {
		System.out.println("Diving Publisher has Stoped.");

		// Service unregister 
		publisherServiceRegistration.unregister();
	}

	


}
