package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired // springbean이 알아서 읽어서 레포지토리에 주입해줌 = 디펜던시인젝션
    private BoardRepository boardRepository;

    // 글 작성
    public void write(Board board) {

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
