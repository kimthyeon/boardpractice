package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class BoardService {

    @Autowired // springbean이 알아서 읽어서 레포지토리에 주입해줌 = 디펜던시인젝션
    private BoardRepository boardRepository;

    // 글 작성
    public void write(Board board, MultipartFile file) throws Exception{

        String projectPath = System.getProperty("user.dir")  // 프로젝트 경로를 담아줌.
                + "\\src\\main\\resources\\static\\files"; // 경로

        UUID uuid = UUID.randomUUID();

        String fileName = uuid + "_" + file.getOriginalFilename(); // 랜덤으로 식별자가 붙고, "_" + 파일이름.

        File saveFile = new File(projectPath,fileName); // 파일을 넣어줄 껍데기 생성(경로 지정, 파일이름지정)

        file.transferTo(saveFile);

        board.setFilename(fileName);
        board.setFilepath("/files/" + fileName); // 서버에서 접근할 때, static 밑에 있는 경로는 \아래의 경로만 접근이 가능

        boardRepository.save(board);
    }

    // 게시글 리스트
    public List<Board> boardList() {

        return boardRepository.findAll();
    }

    // 특정 게시글 불러오기
    public Board boardView(Integer id) {

        return boardRepository.findById(id).get(); // findById는 optional로 받아옴. get() 으로 받아오면 오류가 사라짐.
    }

    // 글 삭제
    public void boardDelete(Integer id) { // 메소드에서 return 타입이 없는게 void

        boardRepository.deleteById(id);
    }

}
