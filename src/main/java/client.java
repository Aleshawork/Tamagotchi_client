import my.experiments.services.LiveMetrics;
import my.experiments.services.MyPetSOAPService;
import my.experiments.services.MyPetSOAPServiceService;


public class client {

	public static void main(String[] args) throws InterruptedException {
		MyPetSOAPServiceService service = new MyPetSOAPServiceService();
		MyPetSOAPService client = service.getMyPetSOAPServicePort();
		LiveMetrics pet = client.feel();
		boolean dead = false;
		do {
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			if (pet.getHealth()<1) {
				System.out.printf("            (%s)   I'm %s... why? Why? WHY?!!\n\n", pet.getFace(), "dead");
				dead = true;
			}
			else
				System.out.printf("            (%s)   I'm %s!\n\n", pet.getFace(), pet.getMood());
			System.out.printf("\n �������e: %3d%%          �����: %3d%%\n[%s%s]  [%s%s]"
					,pet.getHealth()
					,pet.getHunger()
					, "�".repeat(pet.getHealth()/5)
					, "_".repeat(20 - pet.getHealth()/5)
					, "�".repeat(pet.getHunger()/5)
					, "_".repeat(20 - pet.getHunger()/5));
			System.out.printf("\n ��������: %3d%%          �����: %3d%%\n[%s%s]  [%s%s]"
					,pet.getInfection()
					,pet.getThirst()
					, "�".repeat(pet.getInfection()/5)
					, "_".repeat(20 - pet.getInfection()/5)
					, "�".repeat(pet.getThirst()/5)
					, "_".repeat(20 - pet.getThirst()/5));
			Thread.sleep(1000);
			pet = client.feel();
		} while (pet.getHealth() > 0 || !dead);

	}

}
