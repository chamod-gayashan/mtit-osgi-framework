package pub_hillclimb;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class HillClimbActivator implements BundleActivator {

	ServiceRegistration publisherServiceReg;

	// The start method for the Hiking Publisher
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Hiking Publisher has Started.");

		HillClimbPublisher hillClimbPublisher = new HillClimbPubImpl();

		// Register service to the service registry(bind the service)
		publisherServiceReg = bundleContext.registerService(HillClimbPublisher.class.getName(), hillClimbPublisher,
				null);
	}

	// The stop method for the Hiking Publisher
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Hiking Publisher has Stopped");

		// Unregister service from the service registry
		publisherServiceReg.unregister();
	}

}
