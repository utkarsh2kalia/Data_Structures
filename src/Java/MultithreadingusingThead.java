package Java;

public class MultithreadingusingThead extends Thread{

    public void run()
    {
        try{
            System.out.println("Thread"+Thread.currentThread().getId());
        }
        catch(Exception e){
            System.out.println("Exception caught:"+e.getMessage());
        }

    }

    public static void main(String[] args) {
        for (int i = 1; i < 5; i++) {
            MultithreadingusingThead obj = new MultithreadingusingThead();
            obj.start();
        }
    }

}
