CREATE DATABASE  IF NOT EXISTS `scrapperdb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `scrapperdb`;
-- MySQL dump 10.13  Distrib 5.5.44, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: scrapperdb
-- ------------------------------------------------------
-- Server version	5.5.44-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user_details`
--

DROP TABLE IF EXISTS `user_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_details` (
  `id` int(11) NOT NULL,
  `first_name` varchar(200) DEFAULT NULL,
  `last_name` varchar(200) DEFAULT NULL,
  `email_id` varchar(200) DEFAULT NULL,
  `mobile_number` varchar(200) DEFAULT NULL,
  `date_of_birth` varchar(200) DEFAULT NULL,
  `country` varchar(200) DEFAULT NULL,
  `state` varchar(200) DEFAULT NULL,
  `city` varchar(200) DEFAULT NULL,
  `address` text,
  `experience_month` varchar(200) DEFAULT NULL,
  `experience_year` varchar(200) DEFAULT NULL,
  `current_organization` varchar(200) DEFAULT NULL,
  `current_designation` varchar(200) DEFAULT NULL,
  `current_salary` varchar(200) DEFAULT NULL,
  `expected_salary` varchar(200) DEFAULT NULL,
  `skills` varchar(500) DEFAULT NULL,
  `qualification` varchar(200) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_details`
--

LOCK TABLES `user_details` WRITE;
/*!40000 ALTER TABLE `user_details` DISABLE KEYS */;
INSERT INTO `user_details` VALUES (1,'Sajin','Varughese','sajinvarughese@gmail.com','9447037214','16/06/1989','India','Kerala','Thiruvalla','Paratholil House, Nellimala P O, Thiruvalla','2','2','UMN','Software Engineer','2.5 lakh','3.5 lakh','JAVA, JSP, SPRING, HIBERNATE, JQUERY, JSOUP, SELENIUM','BTECH','Male');
/*!40000 ALTER TABLE `user_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apply_details`
--

DROP TABLE IF EXISTS `apply_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apply_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company` varchar(200) DEFAULT NULL,
  `formfill_url` varchar(200) DEFAULT NULL,
  `apply_url` varchar(200) DEFAULT NULL,
  `form_type` varchar(200) DEFAULT NULL,
  `parameter_count` int(11) DEFAULT NULL,
  `full_name` varchar(200) DEFAULT NULL,
  `first_name` varchar(200) DEFAULT NULL,
  `last_name` varchar(200) DEFAULT NULL,
  `email_id` varchar(200) DEFAULT NULL,
  `mobile_number` varchar(200) DEFAULT NULL,
  `date_of_birth` varchar(200) DEFAULT NULL,
  `country` varchar(200) DEFAULT NULL,
  `state` varchar(200) DEFAULT NULL,
  `city` varchar(200) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `experience` varchar(200) DEFAULT NULL,
  `experience_month` varchar(200) DEFAULT NULL,
  `experience_year` varchar(200) DEFAULT NULL,
  `current_organization` varchar(200) DEFAULT NULL,
  `current_designation` varchar(200) DEFAULT NULL,
  `current_salary` varchar(200) DEFAULT NULL,
  `expected_salary` varchar(200) DEFAULT NULL,
  `notice_period` varchar(45) DEFAULT NULL,
  `submit_id` varchar(200) DEFAULT NULL,
  `resume_uploader_id` varchar(200) DEFAULT NULL,
  `hidden_input_fields` text,
  `skills` varchar(500) DEFAULT NULL,
  `apply_post` varchar(45) DEFAULT NULL,
  `qualification` varchar(200) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apply_details`
--

LOCK TABLES `apply_details` WRITE;
/*!40000 ALTER TABLE `apply_details` DISABLE KEYS */;
INSERT INTO `apply_details` VALUES (1,'VGN Infra India','http://www.vgn.in/job/project-incharge-construction','http://www.vgn.in/job/project-incharge-construction','2',NULL,'user_fname',NULL,NULL,'user_email','user_phn','user_dob~|~dd/MM/yyyy','user_country','user_rgn','user_cty',NULL,'user_exp',NULL,NULL,NULL,NULL,'user_slry',NULL,NULL,'btnsubform~|~Submit Application','myfile',NULL,NULL,NULL,NULL,NULL),(2,'The Sethia Group','http://sethiainfra.com/CareerApply.aspx?jobid=12','http://sethiainfra.com/CareerApply.aspx?jobid=12','2',NULL,'ctl00$ContentPlaceHolder1$txtName',NULL,NULL,'ctl00$ContentPlaceHolder1$txtEmail','ctl00$ContentPlaceHolder1$txtNo',NULL,NULL,NULL,NULL,'ctl00$ContentPlaceHolder1$txtAddress','ctl00$ContentPlaceHolder1$ddlExp','',NULL,'ctl00$ContentPlaceHolder1$txtCurrentOrganization','ctl00$ContentPlaceHolder1$txtCurrentDesignation','ctl00$ContentPlaceHolder1$txtCurrentGrossSalary',NULL,NULL,NULL,'ctl00$ContentPlaceHolder1$FileUpload1','__VIEWSTATE~:~__VIEWSTATEGENERATOR~:~__EVENTVALIDATION~:~__EVENTTARGET~:~ToolkitScriptManager1_HiddenField~:~__EVENTARGUMENT~:~ctl00$ContentPlaceHolder1$imgSubmit.x~|~40~:~ctl00$ContentPlaceHolder1$imgSubmit.y~|~11~:~ctl00$ContentPlaceHolder1$txtShortDescription~:~ctl00$ContentPlaceHolder1$txtCity',NULL,NULL,NULL,NULL),(3,'LIQVID eLearning Services','http://www.liqvid.com/careers-job-req.php?jobid=29','http://www.liqvid.com/careers-job-req.php?jobid=29','2',NULL,'jobname',NULL,NULL,'email','phone',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'submit~|~Submit','resume','x~|~22~:~y~|~10~:~jobname~:~jobid','brief',NULL,NULL,NULL),(4,'Cyberframe','http://www.cyberframe.in/apply.php?POS=Trainie%20SEO','http://www.cyberframe.in/apply.php?POS=Trainie%20SEO','2',NULL,'name',NULL,NULL,'email','phone',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'submit~|~Submit','upload_file','radio~|~resume~:~editor2~:~editor1',NULL,NULL,NULL,NULL),(5,'SVS Global Softech','http://www.svsglobalsoftech.com/applicationform.php','http://www.svsglobalsoftech.com/applicationform.php','1',NULL,'name',NULL,NULL,'email','phone_no','date~|~MM/dd/yyyy',NULL,NULL,NULL,'address',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Submit~|~Submit','photo','submitted~:~id3b1b21aa0e3941053c76~:~sp33a65d6862e3f8457fc0e39702227ac7',NULL,'postapply~|~Business Development Executive','qualification~:~highestqualification','gender'),(6,'Voyants Solutions','http://www.voyants.in/careers/electrical-design-transmission-distribution/','http://www.voyants.in/careers/electrical-design-transmission-distribution/','2',0,'name',NULL,NULL,'email','phone',NULL,NULL,NULL,'location',NULL,NULL,NULL,NULL,'organization',NULL,NULL,NULL,NULL,NULL,'resume','_wpcf7~:~_wpcf7_version~:~_wpcf7_locale~:~_wpcf7_unit_tag~:~_wpnonce~:~additional-info~:~_wpcf7_is_ajax_call~|~1',NULL,NULL,NULL,NULL),(7,'Acesoft Labs','http://www.acesoftlabs.com/file.aspx?id=ACS0907DC','http://www.acesoftlabs.com/file.aspx?id=ACS0907DC','2',NULL,'uname',NULL,NULL,'uemail','unumber',NULL,NULL,NULL,'jlocation',NULL,'uexperience',NULL,NULL,'curntemplr',NULL,NULL,NULL,NULL,'Button1~|~Submit','FileUpload1','__EVENTTARGET~:~__EVENTARGUMENT~:~__VIEWSTATE~:~__EVENTVALIDATION~:~HiddenField1~:~altrntphne~:~sskills~:~prjoblocn~:~cctc~:~ectc~:~nperiod','pskills',NULL,NULL,NULL),(8,'Mayo Technologies','http://mayotech.in/apply_now.php?id=39','http://mayotech.in/send_resume.php','2',NULL,'name1',NULL,NULL,'email_add','phone_mobile',NULL,NULL,NULL,NULL,NULL,NULL,'expe_month','expe_yr','',NULL,NULL,'',NULL,'submit~|~Submit','filename','job_title~:~ref~:~company~:~location_name~:~title~:~','key_skill',NULL,NULL,NULL),(9,'Vee Technologies','http://www.veetechnologies.com/careers/apply-resume.htm','http://www.veetechnologies.com/careers/apply-resume.htm?chronoform=Apply_Resume&event=submit','1',NULL,NULL,'input_text_1','input_text_2','input_text_4','input_text_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'input_submit_8~|~Submit','file_upload','cb5baa07d4b4b4ff924f9bb3e3997924',NULL,'input_text_5~|~MC3101',NULL,NULL),(10,'Virtela Technology Services','http://www.virtela.net/careers-mumbai/linux-monitoring-tools-engineer-india/','http://www.virtela.net/careers-mumbai/linux-monitoring-tools-engineer-india/','2',NULL,'full-name',NULL,NULL,'email-address',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'file-671','_wpcf7~:~_wpcf7_version~:~_wpcf7_locale~:~_wpcf7_unit_tag~:~_wpnonce~:~jobposition~:~_wpcf7_is_ajax_call~|~1',NULL,NULL,NULL,NULL),(11,'Au Financiers','http://www.aufin.in/index.php?option=com_jobboard&view=apply&job_id=226&catid=1&lyt=list&Itemid=75','http://www.aufin.in/index.php?option=com_jobboard&view=upload&Itemid=75','2',NULL,'title','first_name','last_name','email','tel',NULL,NULL,'state','appcity','address',NULL,NULL,'tot_exp','company_name',NULL,NULL,NULL,NULL,'submit_application~|~Submit','cv','form_submit~|~submitted~:~job_id~:~position~:~city~:~catid~:~cover_text~:~current_location~:~current_ctc~:~preff_loc~:~0f56dd93566c384dd241ed7e5868c091~|~1',NULL,NULL,'qualification',NULL),(12,'Ecentric HR','http://ecentrichr.com/careers/job/?dot-net-developer','http://ecentrichr.com/submituploadform.php','3',NULL,'ecentric_contact_name',NULL,NULL,'ecentric_contact_email','ecentric_contact_mobile',NULL,NULL,NULL,'ecentric_contact_location',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'ecentric_contact_salary',NULL,NULL,'ecentric_contact_resume','ecentric_contact_comments',NULL,'title~|~Dot Net developer',NULL,NULL),(13,'Nablasol','http://www.nablasol.com/careers/digital-marketing-associate-content-specialist/','http://www.nablasol.com/careers/digital-marketing-associate-content-specialist/','2',NULL,'your-name',NULL,NULL,'your-email','phoneno',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'salarydrawn','expectedsalary',NULL,NULL,'file-46','_wpcf7~:~_wpcf7_version~:~_wpcf7_locale~:~_wpcf7_unit_tag~:~_wpnonce~:~_wpcf7_is_ajax_call~|~1',NULL,NULL,NULL,NULL),(14,'QAI Global','http://www.qaiglobal.com/careers/','http://www.qaiglobal.com/careers/','1',NULL,'ninja_forms_field_13',NULL,NULL,'ninja_forms_field_15','ninja_forms_field_23',NULL,'ninja_forms_field_22','ninja_forms_field_19','ninja_forms_field_17','ninja_forms_field_14','',NULL,'ninja_forms_field_25~:~ninja_forms_field_26',NULL,NULL,NULL,NULL,NULL,'_ninja_forms_field_28~|~Submit','ninja_forms_field_27[new][]','_wpnonce~:~_wp_http_referer~:~_ninja_forms_display_submit~:~_form_id~:~_uLDaJ~:~_hp_name~:~ninja_forms_field_20~:~ninja_forms_field_24~:~MAX_FILE_SIZE~:~ninja_forms_field_27[]',NULL,'ninja_forms_field_29~|~Lead- Inside Sales',NULL,NULL),(15,'Mirafra Technologies','http://www.mirafra.com/careers/apply-online','http://www.mirafra.com/careers/apply-online','1',NULL,NULL,'ctl00$ContentPlaceHolder1$txtFName','ctl00$ContentPlaceHolder1$txtLName','ctl00$ContentPlaceHolder1$txtEmailId','ctl00$ContentPlaceHolder1$txtMobileNo',NULL,'ctl00$ContentPlaceHolder1$txtCountry','ctl00$ContentPlaceHolder1$txtState',NULL,'ctl00$ContentPlaceHolder1$txtAddress',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'ctl00$ContentPlaceHolder1$FileUploadResume','ctl00$TextBoxWatermarkExtender1_ClientState~:~ctl00$txtsearch~:~__EVENTVALIDATION~:~__VIEWSTATEGENERATOR~:~__VIEWSTATE~:~__EVENTARGUMENT~:~__EVENTTARGET~|~ctl00$ContentPlaceHolder1$lnkSubmit',NULL,'ctl00$ContentPlaceHolder1$ddlJobCategory~|~12','ctl00$ContentPlaceHolder1$txtEducation',NULL),(16,'e-Zest Solutions','http://www.e-zest.net/career/application-form/','http://www.e-zest.net/career/application-form/#usermessage2a','1',NULL,'Your-Name',NULL,NULL,'Your-Email','Mobile/Phone-No','Birth-Date-(DD/MM/YYYY)~|~dd/MM/yyyy','Country',NULL,NULL,'Address-Infomation','Experience~:~Experience-Summary',NULL,NULL,'Current-Company','Basic-Information~:~Position','Current-CTC','Expected-CTC','Notice-Period~$~','sendbutton2~|~1','cf_uploadfile2[]','Roles-&-Responsibilities~:~comment_post_ID2~:~cforms_pl2~:~cf_working2~:~cf_failure2~:~cf_codeerr2~:~cf_customerr2~:~cf_popup2','Key-Skills','Job-Title~|~Angular Js Developer',NULL,'Gender'),(17,'CitiusTech','http://www.citiustech.com/aboutus/applynow.aspx?j=RBBcjQ2ZZx8%3d','http://www.citiustech.com/aboutus/applynow.aspx?j=RBBcjQ2ZZx8%3d','2',NULL,'','First_Name','Last_Name','Email','Phone',NULL,'',NULL,'Location_Preference',NULL,'Work_Experience',NULL,NULL,'Current_Company','Current_Designation',NULL,NULL,NULL,'btnsubmit~|~Submit',NULL,'__EVENTTARGET~:~__EVENTARGUMENT~:~__VIEWSTATE~:~__VIEWSTATEGENERATOR~:~_recipients~:~_mailSubject~:~_heading~:~Position_Applying_for',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `apply_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-27 21:23:45
