package mountainPost.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mountainPost.model.service.MountainPostService;
import mountainPost.model.vo.MountainPost;
import mountainPost.model.vo.MtFileData;

/**
 * Servlet implementation class MountainPostWriteServlet
 */
@WebServlet("/mountainPost/write")
public class MountainPostWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MountainPostWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/mountain-climbing/post/mountainPostWrite.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uploadFilePath = request.getServletContext().getRealPath("mtUpload");
		int uploadFileLimit = 1024*1024*5;
		String enctype = "UTF-8";
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileLimit, enctype, new DefaultFileRenamePolicy());
		String fileName = multi.getFilesystemName("m-post-file");
		File uploadFile = multi.getFile("m-post-file");
		String filePath = uploadFile.getPath();
		long fileSize = uploadFile.length();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		Timestamp uploadTime = Timestamp.valueOf(formatter.format(Calendar.getInstance().getTimeInMillis()));
		
		String mName = multi.getParameter("mountain-name");
		HttpSession session = request.getSession();
		String writerId = String.valueOf(session.getAttribute("userId"));
		
		MtFileData fileData = new MtFileData();
		fileData.setMtName(mName);
		fileData.setFileName(fileName);
		fileData.setFilePath(filePath);
		fileData.setFileSize(fileSize);
		fileData.setFileUser(writerId);
		fileData.setUploadTime(uploadTime);
		
		String subject = multi.getParameter("post-sub");
		String mRegion = multi.getParameter("mountain-region");
		String mCourse = multi.getParameter("mountain-course");
		int mTime = Integer.parseInt(multi.getParameter("mountain-time"));
		int mParty = Integer.parseInt(multi.getParameter("mountain-party"));	
		int mLevel = Integer.parseInt(multi.getParameter("mountain-level"));
		String mCaution = multi.getParameter("mountain-caution");
		String mNeed = multi.getParameter("mountain-need");
		String contents = multi.getParameter("post-con");
		MountainPost mPost = new MountainPost();
		mPost.setMountainPostSubject(subject);
		mPost.setMountainRegion(mRegion);
		mPost.setMountainName(mName);
		mPost.setMountainPostWriter(writerId);
		mPost.setMountainCourse(mCourse);
		mPost.setMountainTime(mTime);
		mPost.setMountainParty(mParty);
		mPost.setMountainLevel(mLevel);
		mPost.setMountainCaution(mCaution);
		mPost.setMountainNeed(mNeed);
		mPost.setMountainPostContents(contents);
		int result = new MountainPostService().registerMountainPost(mPost, fileData);
		if(result > 0) {
			response.sendRedirect("/mountainPost/list");
		} else {
			request.getRequestDispatcher("/WEB-INF/views/mountain-climbing/post/serviceFailed.html").forward(request, response);
		}
	}

}
