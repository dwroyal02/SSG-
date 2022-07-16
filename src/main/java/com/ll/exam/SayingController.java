package com.ll.exam;


 import java.util.List;
 import java.util.Scanner;

public class SayingController {
    private Scanner input;
    private SayingService sayingRepository;

    public SayingController(Scanner input) {
        this.input = input;
        sayingRepository = new SayingService();
    }


    public void showList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------");
        List<Saying> setOfSaying = sayingRepository.findAll();

        for (int i = setOfSaying.size() - 1; i >= 0; i--) {
            System.out.printf("%d / %s / %s\n", setOfSaying.get(i).id, setOfSaying.get(i).author, setOfSaying.get(i).saying);
        }
    }

    public void addSaying() {
        System.out.print("명언 : ");
        String putSaying = input.nextLine();
        System.out.print("작가 : ");
        String putAuthor = input.nextLine();


        Saying saying = sayingRepository.addSaying(putSaying, putAuthor);
        System.out.printf("%d번 명언이 등록되었다.\n", saying.id);

    }

    public void removeSaying(Rq rq) {
        int paramId = rq.getIntParam("id", 0);

        if (paramId == 0) {
            System.out.println("id를 입력하세요");
            return;
        }


        Saying sayingToDelete = sayingRepository.findId(paramId);
        if (sayingToDelete == null) {
            System.out.printf("%d번 명언은 없다.\n", paramId);
            return;
        }

        sayingRepository.remove(paramId);
        System.out.printf("%d번 명언이 삭제되었다.\n", paramId);
    }


    public void editSayingByID(Rq rq) {

        int paramId = rq.getIntParam("id", 0);

        if (paramId == 0) {
            System.out.println("id를 입력하세요");
            return;
        }

        Saying sayingToEdit = sayingRepository.findId(paramId);

        if (sayingToEdit == null) {
            System.out.printf("%d번 명언 없어.\n", paramId);
            return;
        }
        System.out.printf("기존 명언 : %s\n", sayingToEdit.saying);
        System.out.printf("새 명언 : ");
        String newContent = input.nextLine().trim();

        System.out.printf("기존 작가 : %s\n", sayingToEdit.author);
        System.out.printf("새 작가 : ");
        String newAuthor = input.nextLine().trim();

        sayingRepository.editById(paramId, newContent, newAuthor);
        System.out.printf("%d번 명언이 수정되었습니다.\n", paramId);

    }




}