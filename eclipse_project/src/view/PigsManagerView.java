package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SpringLayout.Constraints;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import common.Genner;
import common.Constants;
import common.Layer;
import controller.PigsManagerController;

/**
 *
 * @author Dang Nhat Hai Long
 */
public class PigsManagerView extends ViewBase
{

	/**
	 * 
	 */
	private static final long	serialVersionUID						= 363771096351815249L;
	public JPanel				contentpane, _panelTop, _panelMid, _panelBot;
	public JButton				_btnTimKiem, _btnThem, _btnXoa, _btnCapNhat, _btnChoAn, _btnKhamBenh, _btnChonNCC,
			_btnChonMaChuong, _btnChonMaLoaiThucAn, _btnChonMaHeo, _btnTrangChu;
	public JLabel				_lblMaNCC, _lblMaChuong, _lblMaLoaiThucAn, _lblMaNguon, _lblMaHeo, _lblChieuCao,
			_lblChieuDai, _lblCanNang, _lblNgayNuoi, _lblNgayBan, _lblMaTheTai;
	public JTextField			_txtfTimKiem, _txtfMaNCC, _txtfMaChuong, _txtfMaLoaiThucAn, _txtfMaNguon, _txtfMaHeo,
			_txtfChieuCao, _txtfChieuDai, _txtfCanNang, _txtfMaTheTai;
	public JDateChooser			_dateNgayNuoi, _dateNgayBan;
	public JCheckBox			_cbNCC, _cbMaNguon;
	public JComboBox<String>	_cbxTimKiem;
	public JTable				_tbHeo;
	public DefaultTableModel	dtm;

	public static final short	SAVE_DONE_CODE							= 0;
	public static final short	SAVE_FAILURE_CODE						= 1;
	public static final String	SAVE_COMMAND							= "save";
	public static final String	ADD_COMMAND								= "add";
	public static final String	UPDATE_COMMAND							= "update";
	public static final String	REMOVE_COMMAND							= "remove";
	public static final String	SELECT_PROVIDER_COMMAND					= "select provider";
	public static final String	SEARCH_COMMAND							= "search";
	public static final String	SELECT_FOOD_COMMAND						= "select food";
	public static final String	SELECT_STABLES_COMMAND					= "select stables";
	public static final String	EAT_COMMAND								= "eat";
	public static final String	KHAMBENH_COMMAND						= "Kham Benh";
	public static final String	SELECT_MAHEO_FROM_OTHER_JFRAME_COMMAND	= "select ma heo";

	public PigsManagerView() {
		contentpane = new JPanel();
		final Border _border = BorderFactory.createLineBorder(Color.gray);
		SpringLayout sl_contentpane = new SpringLayout();
		contentpane.setLayout(sl_contentpane);

		// Top Panel

		final TitledBorder _titleTimKiem = BorderFactory.createTitledBorder(_border, "Tim kiem");
		_titleTimKiem.setTitleJustification(TitledBorder.CENTER);
		_panelTop = new JPanel();
		_panelTop.setPreferredSize(new Dimension(400, 80));
		_panelTop.setBorder(_titleTimKiem);
		SpringLayout sl_panelTop = new SpringLayout();
		_panelTop.setLayout(sl_panelTop);

		_cbxTimKiem = new JComboBox<String>();
		_cbxTimKiem.addItem("Ma heo");
		_cbxTimKiem.addItem("Ten nha cung cap");
		_cbxTimKiem.addItem("Ten thuc an");
		_txtfTimKiem = new JTextField(20);

		_btnTimKiem = Genner.createButton("Tim kiem", Genner.MEDIUM_SIZE);
		_btnTimKiem.setActionCommand(SEARCH_COMMAND);

		sl_panelTop.putConstraint(SpringLayout.HORIZONTAL_CENTER, _txtfTimKiem, 0, SpringLayout.HORIZONTAL_CENTER,
				_panelTop);
		sl_panelTop.putConstraint(SpringLayout.VERTICAL_CENTER, _txtfTimKiem, 0, SpringLayout.VERTICAL_CENTER,
				_panelTop);

		Layer.put(_btnTimKiem).in(sl_panelTop).leftOf(_txtfTimKiem).withMargin(10);
		sl_panelTop.putConstraint(SpringLayout.VERTICAL_CENTER, _btnTimKiem, 0, SpringLayout.VERTICAL_CENTER,
				_panelTop);

		Layer.put(_cbxTimKiem).in(sl_panelTop).rightOf(_txtfTimKiem).withMargin(10);
		sl_panelTop.putConstraint(SpringLayout.VERTICAL_CENTER, _cbxTimKiem, 0, SpringLayout.VERTICAL_CENTER,
				_panelTop);

		_panelTop.add(_cbxTimKiem);
		_panelTop.add(_txtfTimKiem);
		_panelTop.add(_btnTimKiem);

		// Mid Panel
		_panelMid = new JPanel();
		_panelMid.setPreferredSize(new Dimension(400, 170));
		_panelMid.setBorder(_border);
		SpringLayout sl_panelMid = new SpringLayout();
		_panelMid.setLayout(sl_panelMid);

		_lblMaNCC = new JLabel("Ma NCC");
		_lblMaChuong = new JLabel("Ma chuong");
		_lblMaLoaiThucAn = new JLabel("Ma loai thuc an");
		_lblMaNguon = new JLabel("Ma nguon");
		_lblMaHeo = new JLabel("Ma heo");
		_lblChieuCao = new JLabel("Chieu cao");
		_lblChieuDai = new JLabel("Chieu dai");
		_lblCanNang = new JLabel("Can nang");
		_lblNgayNuoi = new JLabel("Ngay nuoi");
		_lblNgayBan = new JLabel("Ngay ban");
		_lblMaTheTai = new JLabel("Ma the tai");

		_txtfMaNCC = new JTextField(18);
		_txtfMaNCC.setEditable(false);
		_txtfMaChuong = new JTextField(18);
		_txtfMaChuong.setEditable(false);
		_txtfMaLoaiThucAn = new JTextField(18);
		_txtfMaLoaiThucAn.setEditable(false);
		_txtfMaNguon = new JTextField(25);
		_txtfMaHeo = new JTextField(25);
		_txtfMaHeo.setEditable(false);
		_txtfChieuCao = new JTextField(25);
		_txtfChieuDai = new JTextField(25);
		_txtfCanNang = new JTextField(25);
		_txtfMaTheTai = new JTextField(25);
		_txtfMaTheTai.setEditable(false);

		_dateNgayBan = new JDateChooser();
		_dateNgayBan.setEnabled(false);
		_dateNgayNuoi = new JDateChooser();
		
		_cbNCC = new JCheckBox("Nha cung cap");
		_cbMaNguon = new JCheckBox("Ma nguon");
		ButtonGroup _btngroup = new ButtonGroup();
		_btngroup.add(_cbNCC);
		_btngroup.add(_cbMaNguon);

		_btnChonNCC = Genner.createButton("Chon", Genner.MEDIUM_SIZE);
		_btnChonNCC.setActionCommand(SELECT_PROVIDER_COMMAND);
		_btnChonMaChuong = Genner.createButton("Chon", Genner.MEDIUM_SIZE);
		_btnChonMaChuong.setActionCommand(SELECT_STABLES_COMMAND);
		_btnChonMaLoaiThucAn = Genner.createButton("Chon", Genner.MEDIUM_SIZE);
		_btnChonMaLoaiThucAn.setActionCommand(SELECT_FOOD_COMMAND);

		Layer.put(_lblMaNCC).in(sl_panelMid).atTopLeft(_panelMid).withMargin(15);
		Layer.put(_lblMaChuong).in(sl_panelMid).atLeft(_panelMid).withMargin(15).bottomOf(_lblMaNCC).withMargin(15);
		sl_panelMid.putConstraint(SpringLayout.NORTH, _lblMaChuong, 0, SpringLayout.NORTH, _txtfMaChuong);
		Layer.put(_lblMaLoaiThucAn).in(sl_panelMid).atLeft(_panelMid).withMargin(15).bottomOf(_lblMaChuong)
				.withMargin(15);
		sl_panelMid.putConstraint(SpringLayout.NORTH, _lblMaLoaiThucAn, 0, SpringLayout.NORTH, _txtfMaLoaiThucAn);
		Layer.put(_lblMaNguon).in(sl_panelMid).atLeft(_panelMid).withMargin(15).bottomOf(_txtfMaLoaiThucAn)
				.withMargin(15);
		sl_panelMid.putConstraint(SpringLayout.NORTH, _lblMaNguon, 0, SpringLayout.NORTH, _txtfMaNguon);
		Layer.put(_lblMaHeo).in(sl_panelMid).leftOf(_btnChonNCC).withMargin(100).atTop(_panelMid).withMargin(15);
		Layer.put(_lblChieuCao).in(sl_panelMid).leftOf(_btnChonNCC).withMargin(100).bottomOf(_lblMaHeo).withMargin(15);
		sl_panelMid.putConstraint(SpringLayout.NORTH, _lblChieuCao, 0, SpringLayout.NORTH, _txtfChieuCao);
		Layer.put(_lblChieuDai).in(sl_panelMid).leftOf(_btnChonNCC).withMargin(100).bottomOf(_lblChieuCao)
				.withMargin(15);
		sl_panelMid.putConstraint(SpringLayout.NORTH, _lblChieuDai, 0, SpringLayout.NORTH, _txtfChieuDai);
		Layer.put(_lblCanNang).in(sl_panelMid).leftOf(_btnChonNCC).withMargin(100).bottomOf(_lblChieuDai)
				.withMargin(15);
		sl_panelMid.putConstraint(SpringLayout.NORTH, _lblCanNang, 0, SpringLayout.NORTH, _txtfCanNang);
		Layer.put(_lblNgayNuoi).in(sl_panelMid).atTop(_panelMid).withMargin(15).leftOf(_txtfMaHeo).withMargin(100);
		Layer.put(_lblNgayBan).in(sl_panelMid).leftOf(_txtfMaHeo).withMargin(100);
		sl_panelMid.putConstraint(SpringLayout.NORTH, _lblNgayBan, 0, SpringLayout.NORTH, _txtfChieuCao);
		Layer.put(_lblMaTheTai).in(sl_panelMid).leftOf(_txtfMaHeo).withMargin(100).bottomOf(_lblNgayBan).withMargin(15);
		sl_panelMid.putConstraint(SpringLayout.NORTH, _lblMaTheTai, 0, SpringLayout.NORTH, _txtfChieuDai);
		Layer.put(_cbNCC).in(sl_panelMid).leftOf(_txtfMaHeo).withMargin(100).bottomOf(_lblMaTheTai).withMargin(15);
		Layer.put(_cbMaNguon).in(sl_panelMid).leftOf(_cbNCC).withMargin(15).bottomOf(_lblMaTheTai).withMargin(15);

		Layer.put(_txtfMaNCC).in(sl_panelMid).leftOf(_lblMaNCC).withMargin(30).atTop(_panelMid).withMargin(15);
		sl_panelMid.putConstraint(SpringLayout.WEST, _txtfMaNCC, 0, SpringLayout.WEST, _txtfMaLoaiThucAn);
		Layer.put(_txtfMaChuong).in(sl_panelMid).leftOf(_lblMaChuong).withMargin(30).bottomOf(_txtfMaNCC)
				.withMargin(15);
		sl_panelMid.putConstraint(SpringLayout.WEST, _txtfMaChuong, 0, SpringLayout.WEST, _txtfMaLoaiThucAn);
		Layer.put(_txtfMaLoaiThucAn).in(sl_panelMid).leftOf(_lblMaLoaiThucAn).withMargin(30).bottomOf(_txtfMaChuong)
				.withMargin(15);
		Layer.put(_txtfMaNguon).in(sl_panelMid).leftOf(_lblMaNguon).withMargin(30).bottomOf(_txtfMaLoaiThucAn)
				.withMargin(15);
		sl_panelMid.putConstraint(SpringLayout.WEST, _txtfMaNguon, 0, SpringLayout.WEST, _txtfMaLoaiThucAn);
		Layer.put(_txtfMaHeo).in(sl_panelMid).leftOf(_lblChieuDai).withMargin(30).atTop(_panelMid).withMargin(15);
		Layer.put(_txtfChieuCao).in(sl_panelMid).leftOf(_lblChieuDai).withMargin(30).bottomOf(_txtfMaHeo)
				.withMargin(15);
		Layer.put(_txtfChieuDai).in(sl_panelMid).leftOf(_lblChieuDai).withMargin(30).bottomOf(_txtfChieuCao)
				.withMargin(15);
		Layer.put(_txtfCanNang).in(sl_panelMid).leftOf(_lblChieuDai).withMargin(30).bottomOf(_txtfChieuDai)
				.withMargin(15);
		Layer.put(_txtfMaTheTai).in(sl_panelMid).leftOf(_lblMaTheTai).withMargin(15).bottomOf(_dateNgayBan)
				.withMargin(15);
		sl_panelMid.putConstraint(SpringLayout.WEST, _txtfMaTheTai, 0, SpringLayout.WEST, _dateNgayBan);
		sl_panelMid.putConstraint(SpringLayout.EAST, _txtfMaTheTai, 0, SpringLayout.EAST, _dateNgayBan);

		Layer.put(_btnChonNCC).in(sl_panelMid).leftOf(_txtfMaNCC).withMargin(5).atTop(_panelMid).withMargin(15);
		sl_panelMid.putConstraint(SpringLayout.SOUTH, _btnChonNCC, 0, SpringLayout.SOUTH, _txtfMaNCC);
		sl_panelMid.putConstraint(SpringLayout.EAST, _btnChonNCC, 0, SpringLayout.EAST, _txtfMaNguon);
		Layer.put(_btnChonMaChuong).in(sl_panelMid).leftOf(_txtfMaChuong).withMargin(5).bottomOf(_txtfMaNCC)
				.withMargin(15);
		sl_panelMid.putConstraint(SpringLayout.SOUTH, _btnChonMaChuong, 0, SpringLayout.SOUTH, _txtfMaChuong);
		sl_panelMid.putConstraint(SpringLayout.EAST, _btnChonMaChuong, 0, SpringLayout.EAST, _txtfMaNguon);
		Layer.put(_btnChonMaLoaiThucAn).in(sl_panelMid).leftOf(_txtfMaLoaiThucAn).withMargin(5).bottomOf(_txtfMaChuong)
				.withMargin(15);
		sl_panelMid.putConstraint(SpringLayout.SOUTH, _btnChonMaLoaiThucAn, 0, SpringLayout.SOUTH, _txtfMaLoaiThucAn);
		sl_panelMid.putConstraint(SpringLayout.EAST, _btnChonMaLoaiThucAn, 0, SpringLayout.EAST, _txtfMaNguon);
		Layer.put(_dateNgayNuoi).in(sl_panelMid).atTopRight(_panelMid).withMargin(15).leftOf(_lblNgayBan)
				.withMargin(15);
		Layer.put(_dateNgayBan).in(sl_panelMid).atRight(_panelMid).withMargin(15).leftOf(_lblNgayBan).withMargin(15);
		sl_panelMid.putConstraint(SpringLayout.NORTH, _dateNgayBan, 0, SpringLayout.NORTH, _lblNgayBan);
		
		

		_panelMid.add(_lblMaNCC);
		_panelMid.add(_lblMaChuong);
		_panelMid.add(_lblMaLoaiThucAn);
		_panelMid.add(_lblMaNguon);
		_panelMid.add(_lblMaHeo);
		_panelMid.add(_lblChieuCao);
		_panelMid.add(_lblChieuDai);
		_panelMid.add(_lblCanNang);
		_panelMid.add(_lblNgayNuoi);
		_panelMid.add(_lblNgayBan);
		_panelMid.add(_lblMaTheTai);

		_panelMid.add(_txtfMaNCC);
		_panelMid.add(_txtfMaLoaiThucAn);
		_panelMid.add(_txtfMaChuong);
		_panelMid.add(_txtfMaNguon);
		_panelMid.add(_txtfMaHeo);
		_panelMid.add(_txtfChieuCao);
		_panelMid.add(_txtfChieuDai);
		_panelMid.add(_txtfCanNang);
		_panelMid.add(_txtfMaTheTai);

		_panelMid.add(_btnChonNCC);
		_panelMid.add(_btnChonMaChuong);
		_panelMid.add(_btnChonMaLoaiThucAn);

		_panelMid.add(_dateNgayNuoi);
		_panelMid.add(_dateNgayBan);
		_panelMid.add(_cbNCC);
		_panelMid.add(_cbMaNguon);

		// Bot Panel
		_panelBot = new JPanel();
		_panelBot.setPreferredSize(new Dimension(1100, 350));
		final TitledBorder _titleBotLeft = BorderFactory.createTitledBorder(_border, "Danh sach Heo");
		_panelBot.setBorder(_titleBotLeft);

		final String[] _columnsHeo =
		{ "Ma chuong", "Tinh trang", "So luong toi da", "Vi tri", "Mo ta" };
		_tbHeo = new JTable(new Object[0][0], _columnsHeo);
		_tbHeo.setFillsViewportHeight(true);
		JScrollPane _scrolltbNCC = new JScrollPane(_tbHeo, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		BorderLayout bl_BotLeft = new BorderLayout();
		_panelBot.setLayout(bl_BotLeft);
		_panelBot.add(_scrolltbNCC);

		// Button
		_btnThem = Genner.createButton("Them", Genner.MEDIUM_SIZE);
		_btnThem.setActionCommand(ADD_COMMAND);
		_btnXoa = Genner.createButton("Xoa", Genner.MEDIUM_SIZE);
		_btnXoa.setActionCommand(REMOVE_COMMAND);
		_btnCapNhat = Genner.createButton("Cap nhat", Genner.MEDIUM_SIZE);
		_btnCapNhat.setActionCommand(UPDATE_COMMAND);
		_btnChoAn = Genner.createButton("Cho an", Genner.MEDIUM_SIZE);
		_btnChoAn.setActionCommand(EAT_COMMAND);
		_btnKhamBenh = Genner.createButton("Kham benh", Genner.MEDIUM_SIZE);
		_btnKhamBenh.setActionCommand(KHAMBENH_COMMAND);
		_btnChonMaHeo = Genner.createButton("Chon heo", Genner.MEDIUM_SIZE);
		_btnChonMaHeo.setEnabled(false);
		_btnChonMaHeo.setActionCommand(SELECT_MAHEO_FROM_OTHER_JFRAME_COMMAND);
		_btnTrangChu  = Genner.createButton("Trang Chu", Genner.BIG_SIZE);
		_btnTrangChu.setActionCommand(Constants.AC_HOME);


		// Layer
		Layer.put(_panelTop).in(sl_contentpane).atTop(contentpane).withMargin(15).atLeft(contentpane).withMargin(300)
				.atRight(contentpane).withMargin(300);
		Layer.put(_panelMid).in(sl_contentpane).bottomOf(_panelTop).withMargin(15).atLeft(contentpane).withMargin(30)
				.atRight(contentpane).withMargin(30);
		Layer.put(_panelBot).in(sl_contentpane).bottomOf(_panelMid).withMargin(15).atLeft(contentpane).withMargin(30);

		Layer.put(_btnThem).in(sl_contentpane).atBottom(contentpane).withMargin(5).atLeft(contentpane).withMargin(300)
				.bottomOf(_panelBot).withMargin(5);
		Layer.put(_btnXoa).in(sl_contentpane).atBottom(contentpane).withMargin(5).leftOf(_btnThem).withMargin(100)
				.bottomOf(_panelBot).withMargin(5);
		Layer.put(_btnCapNhat).in(sl_contentpane).atBottom(contentpane).withMargin(5).leftOf(_btnXoa).withMargin(100)
				.bottomOf(_panelBot).withMargin(5);

		Layer.put(_btnChoAn).in(sl_contentpane).bottomOf(_panelMid).withMargin(100).atRight(contentpane).withMargin(50)
				.leftOf(_panelBot).withMargin(50);
		Layer.put(_btnKhamBenh).in(sl_contentpane).bottomOf(_btnChoAn).withMargin(50).atRight(contentpane)
				.withMargin(50).leftOf(_panelBot).withMargin(50);
		;
		Layer.put(_btnChonMaHeo).in(sl_contentpane).bottomOf(_btnKhamBenh).withMargin(50).atRight(contentpane)
				.withMargin(50).leftOf(_panelBot).withMargin(50);
		;
		Layer.put(_btnTrangChu).in(sl_contentpane).bottomOf(_btnChonMaHeo).withMargin(60).atRight(contentpane)
		.withMargin(25).leftOf(_panelBot).withMargin(25);
		
		contentpane.add(_panelTop);
		contentpane.add(_panelMid);
		contentpane.add(_panelBot);
		contentpane.add(_btnThem);
		contentpane.add(_btnXoa);
		contentpane.add(_btnCapNhat);
		contentpane.add(_btnChoAn);
		contentpane.add(_btnKhamBenh);
		contentpane.add(_btnChonMaHeo);
		contentpane.add(_btnTrangChu);

		// Set form
		setPreferredSize(new Dimension(1366, 730));
		setResizable(false);
		setTitle("Quan ly heo");
		setContentPane(new JScrollPane(contentpane));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setController(PigsManagerController pmc)
	{
		_btnTimKiem.addActionListener(pmc);
		_btnChonNCC.addActionListener(pmc);
		_btnChonMaChuong.addActionListener(pmc);
		_btnChonMaLoaiThucAn.addActionListener(pmc);
		_btnThem.addActionListener(pmc);
		_btnXoa.addActionListener(pmc);
		_btnCapNhat.addActionListener(pmc);
		_btnChoAn.addActionListener(pmc);
		_btnKhamBenh.addActionListener(pmc);
		_btnChonMaHeo.addActionListener(pmc);
		_btnTrangChu.addActionListener(pmc);

		_tbHeo.addMouseListener(pmc);
	}

	void notice(short code)
	{

	}

}
