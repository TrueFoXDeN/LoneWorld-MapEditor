package clocks;

public class ApplicationLoop implements Runnable{

    public static boolean running = false;

    public static void start(){
        running = true;
        new Thread(new ApplicationLoop()).start();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        final double FPS = 60.0;
        double ns = 1000000000 / FPS;
        double deltaTime = 0;

        while (running) {

            try {
                long currentTime = System.nanoTime();
                deltaTime += (currentTime - lastTime) / ns;
                lastTime = currentTime;

                if (deltaTime >= 1) {
                    render();
                    deltaTime --;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void render(){

    }
}
