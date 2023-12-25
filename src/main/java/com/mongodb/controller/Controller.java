package com.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.model.Student;
import com.mongodb.repo.StudentRepository;
import com.mongodb.service.SendingMail;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/student")
public class Controller {
	@Autowired
	private StudentRepository studrepo;
	@Autowired
	private SendingMail senderMail;

	@PostMapping("/")
	public ResponseEntity<?> addStudent(@RequestBody Student student){
		Student stud=studrepo.save(student);
		return ResponseEntity.ok(stud);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getStudents(){
		
		return ResponseEntity.ok(this.studrepo.findAll());
	}
	
	@GetMapping("/sendawsmail")
	public ResponseEntity<?> sendAWSmail(){
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("crickonfire@gmail.com");
		message.setTo("ajaysinghrajput352@gmail.com");
		message.setSubject("aws mail message");
		message.setText("welcome aws mail message");
		senderMail.sendAWSMail(message);
		return ResponseEntity.ok("send mail successfuly");
	}
	
	@GetMapping("/send")
	public ResponseEntity<?> sendMail(){
		String tomail="crickonfire@gmail.com";
		String sub="testing send bcc message";
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n"
				+ "<html dir=\"ltr\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" lang=\"en\" style=\"padding:0;Margin:0\">\r\n"
				+ " <head>\r\n"
				+ "  <meta charset=\"UTF-8\">\r\n"
				+ "  <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\r\n"
				+ "  <meta name=\"x-apple-disable-message-reformatting\">\r\n"
				+ "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "  <meta content=\"telephone=no\" name=\"format-detection\">\r\n"
				+ "  <title>New email template 2023-12-20</title><!--[if (mso 16)]>\r\n"
				+ "    <style type=\"text/css\">\r\n"
				+ "    a {text-decoration: none;}\r\n"
				+ "    </style>\r\n"
				+ "    <![endif]--><!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]--><!--[if gte mso 9]>\r\n"
				+ "<xml>\r\n"
				+ "    <o:OfficeDocumentSettings>\r\n"
				+ "    <o:AllowPNG></o:AllowPNG>\r\n"
				+ "    <o:PixelsPerInch>96</o:PixelsPerInch>\r\n"
				+ "    </o:OfficeDocumentSettings>\r\n"
				+ "</xml>\r\n"
				+ "<![endif]--><!--[if !mso]><!-- -->\r\n"
				+ "  <link href=\"https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,700,700i\" rel=\"stylesheet\"><!--<![endif]-->\r\n"
				+ "  <style type=\"text/css\">\r\n"
				+ "#outlook a {\r\n"
				+ "	padding:0;\r\n"
				+ "}\r\n"
				+ ".ExternalClass {\r\n"
				+ "	width:100%;\r\n"
				+ "}\r\n"
				+ ".ExternalClass,\r\n"
				+ ".ExternalClass p,\r\n"
				+ ".ExternalClass span,\r\n"
				+ ".ExternalClass font,\r\n"
				+ ".ExternalClass td,\r\n"
				+ ".ExternalClass div {\r\n"
				+ "	line-height:100%;\r\n"
				+ "}\r\n"
				+ ".es-button {\r\n"
				+ "	mso-style-priority:100!important;\r\n"
				+ "	text-decoration:none!important;\r\n"
				+ "}\r\n"
				+ "a[x-apple-data-detectors] {\r\n"
				+ "	color:inherit!important;\r\n"
				+ "	text-decoration:none!important;\r\n"
				+ "	font-size:inherit!important;\r\n"
				+ "	font-family:inherit!important;\r\n"
				+ "	font-weight:inherit!important;\r\n"
				+ "	line-height:inherit!important;\r\n"
				+ "}\r\n"
				+ ".es-desk-hidden {\r\n"
				+ "	display:none;\r\n"
				+ "	float:left;\r\n"
				+ "	overflow:hidden;\r\n"
				+ "	width:0;\r\n"
				+ "	max-height:0;\r\n"
				+ "	line-height:0;\r\n"
				+ "	mso-hide:all;\r\n"
				+ "}\r\n"
				+ "@media only screen and (max-width:600px) {p, ul li, ol li, a { line-height:150%!important } h1, h2, h3, h1 a, h2 a, h3 a { line-height:120%!important } h1 { font-size:30px!important; text-align:center } h2 { font-size:26px!important; text-align:center } h3 { font-size:20px!important; text-align:center } .es-header-body h1 a, .es-content-body h1 a, .es-footer-body h1 a { font-size:30px!important } .es-header-body h2 a, .es-content-body h2 a, .es-footer-body h2 a { font-size:26px!important } .es-header-body h3 a, .es-content-body h3 a, .es-footer-body h3 a { font-size:20px!important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size:16px!important } .es-content-body p, .es-content-body ul li, .es-content-body ol li, .es-content-body a { font-size:16px!important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size:16px!important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size:12px!important } *[class=\"gmail-fix\"] { display:none!important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align:center!important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align:right!important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align:left!important } .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img { display:inline!important } .es-button-border { display:block!important } a.es-button, button.es-button { font-size:20px!important; display:block!important; padding:10px 0px 10px 0px!important } .es-btn-fw { border-width:10px 0px!important; text-align:center!important } .es-adaptive table, .es-btn-fw, .es-btn-fw-brdr, .es-left, .es-right { width:100%!important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width:100%!important; max-width:600px!important } .es-adapt-td { display:block!important; width:100%!important } .adapt-img { width:100%!important; height:auto!important } .es-m-p0 { padding:0px!important } .es-m-p0r { padding-right:0px!important } .es-m-p0l { padding-left:0px!important } .es-m-p0t { padding-top:0px!important } .es-m-p0b { padding-bottom:0!important } .es-m-p20b { padding-bottom:20px!important } .es-mobile-hidden, .es-hidden { display:none!important } tr.es-desk-hidden, td.es-desk-hidden, table.es-desk-hidden { width:auto!important; overflow:visible!important; float:none!important; max-height:inherit!important; line-height:inherit!important } tr.es-desk-hidden { display:table-row!important } table.es-desk-hidden { display:table!important } td.es-desk-menu-hidden { display:table-cell!important } .es-menu td { width:1%!important } table.es-table-not-adapt, .esd-block-html table { width:auto!important } table.es-social { display:inline-block!important } table.es-social td { display:inline-block!important } .es-menu td a { font-size:14px!important } .es-desk-hidden { display:table-row!important; width:auto!important; overflow:visible!important; max-height:inherit!important } }\r\n"
				+ "@media screen and (max-width:384px) {.mail-message-content { width:414px!important } }\r\n"
				+ "</style>\r\n"
				+ " </head>\r\n"
				+ " <body style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\r\n"
				+ "  <div dir=\"ltr\" class=\"es-wrapper-color\" lang=\"en\" style=\"background-color:#EFEFEF\"><!--[if gte mso 9]>\r\n"
				+ "			<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\r\n"
				+ "				<v:fill type=\"tile\" color=\"#efefef\"></v:fill>\r\n"
				+ "			</v:background>\r\n"
				+ "		<![endif]-->\r\n"
				+ "   <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top;background-color:#EFEFEF\">\r\n"
				+ "     <tr style=\"border-collapse:collapse\">\r\n"
				+ "      <td valign=\"top\" style=\"padding:0;Margin:0\">\r\n"
				+ "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-header\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">\r\n"
				+ "         <tr style=\"border-collapse:collapse\">\r\n"
				+ "          <td align=\"center\" style=\"padding:0;Margin:0\">\r\n"
				+ "           <table class=\"es-header-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\r\n"
				+ "             <tr style=\"border-collapse:collapse\">\r\n"
				+ "              <td align=\"left\" style=\"padding:0;Margin:0\">\r\n"
				+ "               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
				+ "                 <tr style=\"border-collapse:collapse\">\r\n"
				+ "                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:600px\">\r\n"
				+ "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
				+ "                     <tr style=\"border-collapse:collapse\">\r\n"
				+ "                      <td align=\"center\" style=\"Margin:0;padding-left:5px;padding-right:5px;padding-top:10px;padding-bottom:15px;font-size:0\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;color:#000000;font-size:14px\"><img src=\"https://ecargnu.stripocdn.email/content/guids/CABINET_617dc4663911b9a6a2a6d084f0c57099/images/11831502198238658.png\" alt=\"Sport logo\" title=\"Sport logo\" width=\"104\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td>\r\n"
				+ "                     </tr>\r\n"
				+ "                   </table></td>\r\n"
				+ "                 </tr>\r\n"
				+ "               </table></td>\r\n"
				+ "             </tr>\r\n"
				+ "           </table></td>\r\n"
				+ "         </tr>\r\n"
				+ "       </table>\r\n"
				+ "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\r\n"
				+ "         <tr style=\"border-collapse:collapse\">\r\n"
				+ "          <td style=\"padding:0;Margin:0;background-color:#555659\" bgcolor=\"#555659\" align=\"center\">\r\n"
				+ "           <table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#555659;width:600px\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\">\r\n"
				+ "             <tr style=\"border-collapse:collapse\">\r\n"
				+ "              <td align=\"left\" style=\"Margin:0;padding-top:10px;padding-bottom:10px;padding-left:20px;padding-right:20px\">\r\n"
				+ "               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
				+ "                 <tr style=\"border-collapse:collapse\">\r\n"
				+ "                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\">\r\n"
				+ "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
				+ "                     <tr style=\"border-collapse:collapse\">\r\n"
				+ "                      <td style=\"padding:0;Margin:0\">\r\n"
				+ "                       <table class=\"es-menu\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
				+ "                         <tr class=\"links\" style=\"border-collapse:collapse\">\r\n"
				+ "                          <td style=\"Margin:0;padding-left:5px;padding-right:5px;padding-top:0px;padding-bottom:0px;border:0\" width=\"33.33%\" bgcolor=\"transparent\" align=\"center\"><a target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;display:block;font-family:arial, 'helvetica neue', helvetica, sans-serif;color:#ffffff;font-size:14px;font-weight:bold\" href=\"https://viewstripo.email\">WOMEN'S</a></td>\r\n"
				+ "                          <td style=\"Margin:0;padding-left:5px;padding-right:5px;padding-top:0px;padding-bottom:0px;border:0;border-left:1px solid #ffffff\" width=\"33.33%\" bgcolor=\"transparent\" align=\"center\"><a target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;display:block;font-family:arial, 'helvetica neue', helvetica, sans-serif;color:#ffffff;font-size:14px;font-weight:bold\" href=\"https://viewstripo.email\">MEN'S</a></td>\r\n"
				+ "                          <td style=\"Margin:0;padding-left:5px;padding-right:5px;padding-top:0px;padding-bottom:0px;border:0;border-left:1px solid #ffffff\" width=\"33.33%\" bgcolor=\"transparent\" align=\"center\"><a target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;display:block;font-family:arial, 'helvetica neue', helvetica, sans-serif;color:#ffffff;font-size:14px;font-weight:bold\" href=\"https://viewstripo.email\">FIND A STORE</a></td>\r\n"
				+ "                         </tr>\r\n"
				+ "                       </table></td>\r\n"
				+ "                     </tr>\r\n"
				+ "                   </table></td>\r\n"
				+ "                 </tr>\r\n"
				+ "               </table></td>\r\n"
				+ "             </tr>\r\n"
				+ "           </table></td>\r\n"
				+ "         </tr>\r\n"
				+ "       </table>\r\n"
				+ "       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\r\n"
				+ "         <tr style=\"border-collapse:collapse\">\r\n"
				+ "          <td align=\"center\" style=\"padding:0;Margin:0\">\r\n"
				+ "           <table class=\"es-content-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\r\n"
				+ "             <tr style=\"border-collapse:collapse\">\r\n"
				+ "              <td style=\"padding:0;Margin:0;background-color:#43285f\" bgcolor=\"#43285f\" align=\"left\">\r\n"
				+ "               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
				+ "                 <tr style=\"border-collapse:collapse\">\r\n"
				+ "                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:600px\">\r\n"
				+ "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
				+ "                     <tr style=\"border-collapse:collapse\">\r\n"
				+ "                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0\"><img class=\"adapt-img\" src=\"https://ecargnu.stripocdn.email/content/guids/CABINET_18b9b37a94ea92e75434475b4360dcd0/images/36441502442545607.jpg\" alt=\"Happy Birthday!\" title=\"Happy Birthday!\" width=\"600\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td>\r\n"
				+ "                     </tr>\r\n"
				+ "                   </table></td>\r\n"
				+ "                 </tr>\r\n"
				+ "               </table></td>\r\n"
				+ "             </tr>\r\n"
				+ "             <tr style=\"border-collapse:collapse\">\r\n"
				+ "              <td style=\"padding:0;Margin:0;padding-bottom:30px;background-color:#43285f\" bgcolor=\"#43285f\" align=\"left\"><!--[if mso]><table style=\"width:600px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:207px\"><![endif]-->\r\n"
				+ "               <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\r\n"
				+ "                 <tr style=\"border-collapse:collapse\">\r\n"
				+ "                  <td class=\"es-m-p0r es-m-p20b\" align=\"center\" style=\"padding:0;Margin:0;width:187px\">\r\n"
				+ "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
				+ "                     <tr class=\"es-hidden\" style=\"border-collapse:collapse\">\r\n"
				+ "                      <td align=\"left\" style=\"padding:0;Margin:0;font-size:0\"><img src=\"https://ecargnu.stripocdn.email/content/guids/CABINET_18b9b37a94ea92e75434475b4360dcd0/images/27021502445622301.jpg\" alt=\"Very lovely balloon\" title=\"Very lovely balloon\" width=\"116\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td>\r\n"
				+ "                     </tr>\r\n"
				+ "                   </table></td>\r\n"
				+ "                  <td class=\"es-hidden\" style=\"padding:0;Margin:0;width:20px\"></td>\r\n"
				+ "                 </tr>\r\n"
				+ "               </table><!--[if mso]></td><td style=\"width:187px\"><![endif]-->\r\n"
				+ "               <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\r\n"
				+ "                 <tr style=\"border-collapse:collapse\">\r\n"
				+ "                  <td class=\"es-m-p20b\" align=\"center\" style=\"padding:0;Margin:0;width:187px\">\r\n"
				+ "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
				+ "                     <tr style=\"border-collapse:collapse\">\r\n"
				+ "                      <td align=\"center\" style=\"padding:0;Margin:0;padding-top:15px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:24px;color:#ffffff;font-size:14px\"><span style=\"font-size:16px\"><span style=\"font-family:arial, 'helvetica neue', helvetica, sans-serif\"><span style=\"line-height:150%\">Dear Katrina, it's your birthday and we think you deserve a little gift</span></span></span></p></td>\r\n"
				+ "                     </tr>\r\n"
				+ "                     <tr style=\"border-collapse:collapse\">\r\n"
				+ "                      <td align=\"center\" style=\"padding:0;Margin:0;padding-top:10px;padding-bottom:20px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:98px;color:#ffffff;font-size:14px\"><span style=\"font-family:'playfair display', georgia, 'times new roman', serif;line-height:98px\"><span style=\"font-size:65px;line-height:98px\"><span style=\"line-height:36px\"><span style=\"line-height:36px\"><span style=\"line-height:36px\"><span style=\"line-height:36px\"><span style=\"line-height:36px\">15% <span style=\"font-size:24px;line-height:36px\">off</span></span></span></span></span></span></span></span></p></td>\r\n"
				+ "                     </tr>\r\n"
				+ "                     <tr style=\"border-collapse:collapse\">\r\n"
				+ "                      <td align=\"center\" style=\"padding:0;Margin:0;padding-left:10px;padding-right:10px;padding-bottom:30px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#ffffff;font-size:14px\"><span style=\"font-size:13px;line-height:20px\">YOUR NEXT ORDER + </span>FREE SHIPPING!</p></td>\r\n"
				+ "                     </tr>\r\n"
				+ "                     <tr style=\"border-collapse:collapse\">\r\n"
				+ "                      <td align=\"center\" style=\"Margin:0;padding-top:5px;padding-bottom:5px;padding-left:10px;padding-right:10px\"><span class=\"es-button-border\" style=\"border-style:solid;border-color:#FFFFFF;background:#2CB543;border-width:0px;display:block;border-radius:0px;width:auto\"><a href=\"https://viewstripo.email/\" class=\"es-button\" target=\"_blank\" style=\"mso-style-priority:100 !important;text-decoration:none;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;color:#9A7BAA;font-size:18px;display:block;background:#FFFFFF;border-radius:0px;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-weight:bold;font-style:normal;line-height:22px;width:auto;text-align:center;padding:10px 20px 10px 20px;mso-padding-alt:0;mso-border-alt:10px solid #FFFFFF;padding-left:0px;padding-right:0px\">+ Shop now</a></span></td>\r\n"
				+ "                     </tr>\r\n"
				+ "                   </table></td>\r\n"
				+ "                 </tr>\r\n"
				+ "               </table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:186px\"><![endif]-->\r\n"
				+ "               <table class=\"es-right\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\r\n"
				+ "                 <tr style=\"border-collapse:collapse\">\r\n"
				+ "                  <td align=\"center\" style=\"padding:0;Margin:0;width:186px\">\r\n"
				+ "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
				+ "                     <tr class=\"es-hidden\" style=\"border-collapse:collapse\">\r\n"
				+ "                      <td align=\"right\" style=\"padding:0;Margin:0;font-size:0\"><img src=\"https://ecargnu.stripocdn.email/content/guids/CABINET_18b9b37a94ea92e75434475b4360dcd0/images/77061502445629778.jpg\" alt=\"Very lovely balloon\" title=\"Very lovely balloon\" width=\"111\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td>\r\n"
				+ "                     </tr>\r\n"
				+ "                   </table></td>\r\n"
				+ "                 </tr>\r\n"
				+ "               </table><!--[if mso]></td></tr></table><![endif]--></td>\r\n"
				+ "             </tr>\r\n"
				+ "           </table></td>\r\n"
				+ "         </tr>\r\n"
				+ "       </table>\r\n"
				+ "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-footer\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">\r\n"
				+ "         <tr style=\"border-collapse:collapse\">\r\n"
				+ "          <td align=\"center\" style=\"padding:0;Margin:0\">\r\n"
				+ "           <table class=\"es-footer-body\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\">\r\n"
				+ "             <tr style=\"border-collapse:collapse\">\r\n"
				+ "              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:10px;padding-left:20px;padding-right:20px\">\r\n"
				+ "               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
				+ "                 <tr style=\"border-collapse:collapse\">\r\n"
				+ "                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\">\r\n"
				+ "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
				+ "                     <tr style=\"border-collapse:collapse\">\r\n"
				+ "                      <td align=\"center\" style=\"padding:0;Margin:0;padding-top:20px;padding-bottom:20px;font-size:0\">\r\n"
				+ "                       <table width=\"100%\" height=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
				+ "                         <tr style=\"border-collapse:collapse\">\r\n"
				+ "                          <td style=\"padding:0;Margin:0;border-bottom:1px solid #cccccc;background:none;height:1px;width:100%;margin:0px\"></td>\r\n"
				+ "                         </tr>\r\n"
				+ "                       </table></td>\r\n"
				+ "                     </tr>\r\n"
				+ "                     <tr style=\"border-collapse:collapse\">\r\n"
				+ "                      <td align=\"center\" style=\"padding:0;Margin:0;padding-top:10px;padding-bottom:10px;font-size:0\">\r\n"
				+ "                       <table class=\"es-table-not-adapt es-social\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
				+ "                         <tr style=\"border-collapse:collapse\">\r\n"
				+ "                          <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:20px\"><img title=\"Twitter\" src=\"https://ecargnu.stripocdn.email/content/assets/img/social-icons/square-colored/twitter-square-colored.png\" alt=\"Tw\" width=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td>\r\n"
				+ "                          <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:20px\"><img title=\"Facebook\" src=\"https://ecargnu.stripocdn.email/content/assets/img/social-icons/square-colored/facebook-square-colored.png\" alt=\"Fb\" width=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td>\r\n"
				+ "                          <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:20px\"><img title=\"Youtube\" src=\"https://ecargnu.stripocdn.email/content/assets/img/social-icons/square-colored/youtube-square-colored.png\" alt=\"Yt\" width=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td>\r\n"
				+ "                          <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:20px\"><img title=\"Linkedin\" src=\"https://ecargnu.stripocdn.email/content/assets/img/social-icons/square-colored/linkedin-square-colored.png\" alt=\"In\" width=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td>\r\n"
				+ "                          <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0\"><img title=\"Pinterest\" src=\"https://ecargnu.stripocdn.email/content/assets/img/social-icons/square-colored/pinterest-square-colored.png\" alt=\"P\" width=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td>\r\n"
				+ "                         </tr>\r\n"
				+ "                       </table></td>\r\n"
				+ "                     </tr>\r\n"
				+ "                   </table></td>\r\n"
				+ "                 </tr>\r\n"
				+ "               </table></td>\r\n"
				+ "             </tr>\r\n"
				+ "           </table></td>\r\n"
				+ "         </tr>\r\n"
				+ "       </table>\r\n"
				+ "       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\r\n"
				+ "         <tr style=\"border-collapse:collapse\">\r\n"
				+ "          <td align=\"center\" style=\"padding:0;Margin:0\">\r\n"
				+ "           <table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n"
				+ "             <tr style=\"border-collapse:collapse\">\r\n"
				+ "              <td align=\"left\" style=\"Margin:0;padding-left:20px;padding-right:20px;padding-top:30px;padding-bottom:30px\">\r\n"
				+ "               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
				+ "                 <tr style=\"border-collapse:collapse\">\r\n"
				+ "                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\">\r\n"
				+ "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
				+ "                     <tr style=\"border-collapse:collapse\">\r\n"
				+ "                      <td class=\"es-infoblock made_with\" align=\"center\" style=\"padding:0;Margin:0;line-height:14px;font-size:0;color:#333333\"><a target=\"_blank\" href=\"https://viewstripo.email/?utm_source=templates&utm_medium=email&utm_campaign=sport&utm_content=holiday_newsletter\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;color:#000000;font-size:12px\"><img src=\"https://ecargnu.stripocdn.email/content/guids/CABINET_9df86e5b6c53dd0319931e2447ed854b/images/64951510234941531.png\" alt width=\"125\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td>\r\n"
				+ "                     </tr>\r\n"
				+ "                   </table></td>\r\n"
				+ "                 </tr>\r\n"
				+ "               </table></td>\r\n"
				+ "             </tr>\r\n"
				+ "           </table></td>\r\n"
				+ "         </tr>\r\n"
				+ "       </table></td>\r\n"
				+ "     </tr>\r\n"
				+ "   </table>\r\n"
				+ "  </div>\r\n"
				+ " </body>\r\n"
				+ "</html>";
		boolean f=false;
		try {
			f = senderMail.sendMailByMe(tomail, sub, msg);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(f);
	}
}
