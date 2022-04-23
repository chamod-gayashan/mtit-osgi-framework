package pub_safari;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.ServiceRegistration;
import org.osgi.framework.BundleContext;

import pub_safari.SafariPublisher;
import pub_safari.SafariPubImpl;

public class SafariActivator implements BundleActivator {

	ServiceRegistration pubServiceReg;

	// The start Adventure Publisher
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Safari Publisher has Started.");

		SafariPublisher SafariPublisher = new SafariPubImpl();

		// Register service to the service registry(bind the service)
		pubServiceReg = bundleContext.registerService(SafariPublisher.class.getName(),
				SafariPublisher, null);
	}

	// The stop Adventure Publisher
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Safari Publisher has Stoped.");

		// Unregister service from the service registry
		pubServiceReg.unregister();
	}

}
