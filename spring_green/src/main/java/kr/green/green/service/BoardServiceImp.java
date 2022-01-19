package kr.green.green.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.green.dao.BoardDAO;
import kr.green.green.utils.UploadFileUtils;
import kr.green.green.vo.BoardVO;
import kr.green.green.vo.FileVO;
import kr.green.green.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{

	@Autowired
	BoardDAO boardDao;
	
	String uploadPath = "D:\\JAVA_TN\\upload";

	@Override
	public List<BoardVO> getBoardList(String bd_type) {
		return boardDao.selectBoardList(bd_type);
	}

	@Override
	public BoardVO getBoard(Integer bd_num) {
		if(bd_num == null || bd_num <= 0)
			return null;
		return boardDao.selectBoard(bd_num);
	}

	@Override
	public void registerBoard(BoardVO board, MemberVO user, List<MultipartFile> files) {
		if(board == null || user == null) 
			return;
		if(board.getBd_title() == null || board.getBd_title().trim().length() == 0)
			return;
		if(user.getMe_id() == null || user.getMe_id().trim().length() == 0)
			return;
		board.setBd_me_id(user.getMe_id());
		boardDao.insertBoard(board);
		
		if(files == null || files.size() == 0)
			return;
		for(MultipartFile tmpFile : files) {
			if(tmpFile != null && tmpFile.getOriginalFilename().length() != 0) {
				try {
					String path = UploadFileUtils.uploadFile(uploadPath, tmpFile.getOriginalFilename(), tmpFile.getBytes());
					FileVO file = new FileVO(tmpFile.getOriginalFilename(), path, board.getBd_num());
					boardDao.insertFile(file);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void modifyBoard(BoardVO board, MemberVO user, List<MultipartFile> files, Integer[] fileNums) {
		if(board == null || user == null || board.getBd_num() <= 0) 
			return;
		if(board.getBd_title() == null || board.getBd_title().trim().length() == 0)
			return;
		BoardVO dbBoard = boardDao.selectBoard(board.getBd_num());
		if(dbBoard == null)
			return;
		if(!dbBoard.getBd_me_id().equals(user.getMe_id()))
			return;
		boardDao.updateBoard(board);
		List<FileVO> fileList = boardDao.selectFileList(board.getBd_num());
		List<FileVO> remainFileList = new ArrayList<FileVO>();
		//가져온 첨부파일들 중에서 fileNums에 일치하는 번호가 있으면 remainFileList에 추가
		//유지해야할 첨부파일이 있는 경우
		if(fileNums != null && fileNums.length != 0) {
			for(FileVO tmp : fileList) {
				for(Integer tmpNum : fileNums) {
					if(tmp.getFi_num() == tmpNum) {
						remainFileList.add(tmp);
					}
				}
			}
			//게시글의 전체 첨부파일중 유지해야할 첨부파일을 제외한 첨부파일을 만듬 
			fileList.removeAll(remainFileList);
		}
		//실제 서버에서 삭제
		if(fileList != null && fileList.size() != 0) {
			for(FileVO tmp : fileList) {
				String fileName = tmp.getFi_name().replace("/", File.separator);
				File file = new File(uploadPath + fileName);
				boardDao.deleteFile(tmp);
				if(file.exists()) {
					file.delete();
				}
			}
		}
		uploadFile(files, board.getBd_num());
	}

	@Override
	public void deleteBoard(Integer bd_num, MemberVO user) {
		if(bd_num == null || bd_num <= 0)
			return;
		BoardVO Board = boardDao.selectBoard(bd_num);
		if(Board == null)
			return;
		if(user != null && Board.getBd_me_id().equals(user.getMe_id()))
			boardDao.deleteBoard(bd_num);
	}

	@Override
	public List<FileVO> getFileList(Integer bd_num) {
		if(bd_num == null || bd_num <= 0)
			return null;
		return boardDao.selectFileList(bd_num);
	}

	private void uploadFile(List<MultipartFile> files, int bd_num) {
		if(files == null || files.size() == 0)
			return;
		for(MultipartFile tmpFile : files) {
			if(tmpFile != null && tmpFile.getOriginalFilename().length() != 0) {
				try {
					String path = UploadFileUtils.uploadFile(uploadPath, tmpFile.getOriginalFilename(), tmpFile.getBytes());
					FileVO fileVo= new FileVO(tmpFile.getOriginalFilename(), path, bd_num);
					boardDao.insertFile(fileVo);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}