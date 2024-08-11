MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ********************************** Unique Stunt Jumps *********************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

 
// Variables for mission

VAR_INT	players_car_usj cash_reward_usj total_completed_usj
VAR_INT usj_number collision_counter_usj do_usj_reward practice_mode slomo
VAR_INT flag_usj1_passed flag_usj2_passed flag_usj3_passed flag_usj4_passed	flag_usj5_passed 
VAR_INT flag_usj6_passed flag_usj7_passed flag_usj8_passed flag_usj9_passed
VAR_INT flag_usj10_passed flag_usj11_passed flag_usj12_passed flag_usj13_passed flag_usj14_passed
VAR_INT flag_usj15_passed flag_usj16_passed	flag_usj17_passed flag_usj18_passed	flag_usj19_passed
VAR_INT flag_usj20_passed flag_usj21_passed flag_usj22_passed flag_usj23_passed flag_usj24_passed
VAR_INT flag_usj25_passed flag_usj26_passed	flag_usj27_passed flag_usj28_passed	flag_usj29_passed
VAR_INT flag_usj30_passed flag_usj31_passed flag_usj32_passed flag_usj33_passed flag_usj34_passed
VAR_INT flag_usj35_passed flag_usj36_passed
VAR_FLOAT car_speed_usj camera_x camera_y camera_z
VAR_FLOAT usj_target_x usj_target_y usj_target_z usj_end_x usj_end_y usj_end_z usj_jump_dist

VAR_FLOAT usj1_trigger_x usj1_trigger_y usj1_trigger_z usj2_trigger_x usj2_trigger_y usj2_trigger_z usj3_trigger_x usj3_trigger_y usj3_trigger_z usj4_trigger_x usj4_trigger_y usj4_trigger_z
VAR_FLOAT usj5_trigger_x usj5_trigger_y usj5_trigger_z usj6_trigger_x usj6_trigger_y usj6_trigger_z usj7_trigger_x usj7_trigger_y usj7_trigger_z usj8_trigger_x usj8_trigger_y usj8_trigger_z
VAR_FLOAT usj9_trigger_x usj9_trigger_y usj9_trigger_z usj10_trigger_x usj10_trigger_y usj10_trigger_z usj11_trigger_x usj11_trigger_y usj11_trigger_z usj12_trigger_x usj12_trigger_y usj12_trigger_z
VAR_FLOAT usj13_trigger_x usj13_trigger_y usj13_trigger_z usj14_trigger_x usj14_trigger_y usj14_trigger_z usj15_trigger_x usj15_trigger_y usj15_trigger_z usj16_trigger_x usj16_trigger_y usj16_trigger_z
VAR_FLOAT usj17_trigger_x usj17_trigger_y usj17_trigger_z usj18_trigger_x usj18_trigger_y usj18_trigger_z usj19_trigger_x usj19_trigger_y usj19_trigger_z usj20_trigger_x usj20_trigger_y usj20_trigger_z
VAR_FLOAT usj21_trigger_x usj21_trigger_y usj21_trigger_z usj22_trigger_x usj22_trigger_y usj22_trigger_z usj23_trigger_x usj23_trigger_y usj23_trigger_z usj24_trigger_x usj24_trigger_y usj24_trigger_z
VAR_FLOAT usj25_trigger_x usj25_trigger_y usj25_trigger_z usj26_trigger_x usj26_trigger_y usj26_trigger_z usj27_trigger_x usj27_trigger_y usj27_trigger_z usj28_trigger_x usj28_trigger_y usj28_trigger_z
VAR_FLOAT usj29_trigger_x usj29_trigger_y usj29_trigger_z usj30_trigger_x usj30_trigger_y usj30_trigger_z usj31_trigger_x usj31_trigger_y usj31_trigger_z usj32_trigger_x usj32_trigger_y usj32_trigger_z
VAR_FLOAT usj33_trigger_x usj33_trigger_y usj33_trigger_z usj34_trigger_x usj34_trigger_y usj34_trigger_z usj35_trigger_x usj35_trigger_y usj35_trigger_z usj36_trigger_x usj36_trigger_y usj36_trigger_z

VAR_FLOAT usj1_target_x usj1_target_y usj1_target_z usj2_target_x usj2_target_y usj2_target_z usj3_target_x usj3_target_y usj3_target_z usj4_target_x usj4_target_y usj4_target_z
VAR_FLOAT usj5_target_x usj5_target_y usj5_target_z usj6_target_x usj6_target_y usj6_target_z usj7_target_x usj7_target_y usj7_target_z usj8_target_x usj8_target_y usj8_target_z
VAR_FLOAT usj9_target_x usj9_target_y usj9_target_z usj10_target_x usj10_target_y usj10_target_z usj11_target_x usj11_target_y usj11_target_z usj12_target_x usj12_target_y usj12_target_z
VAR_FLOAT usj13_target_x usj13_target_y usj13_target_z usj14_target_x usj14_target_y usj14_target_z usj15_target_x usj15_target_y usj15_target_z usj16_target_x usj16_target_y usj16_target_z
VAR_FLOAT usj17_target_x usj17_target_y usj17_target_z usj18_target_x usj18_target_y usj18_target_z usj19_target_x usj19_target_y usj19_target_z usj20_target_x usj20_target_y usj20_target_z
VAR_FLOAT usj21_target_x usj21_target_y usj21_target_z usj22_target_x usj22_target_y usj22_target_z usj23_target_x usj23_target_y usj23_target_z usj24_target_x usj24_target_y usj24_target_z
VAR_FLOAT usj25_target_x usj25_target_y usj25_target_z usj26_target_x usj26_target_y usj26_target_z usj27_target_x usj27_target_y usj27_target_z usj28_target_x usj28_target_y usj28_target_z
VAR_FLOAT usj29_target_x usj29_target_y usj29_target_z usj30_target_x usj30_target_y usj30_target_z usj31_target_x usj31_target_y usj31_target_z usj32_target_x usj32_target_y usj32_target_z
VAR_FLOAT usj33_target_x usj33_target_y usj33_target_z usj34_target_x usj34_target_y usj34_target_z usj35_target_x usj35_target_y usj35_target_z usj36_target_x usj36_target_y usj36_target_z

// ****************************************Mission Start************************************
flag_usj1_passed = 0
flag_usj2_passed = 0
flag_usj3_passed = 0
flag_usj4_passed = 0
flag_usj5_passed = 0
flag_usj6_passed = 0
flag_usj7_passed = 0
flag_usj8_passed = 0
flag_usj9_passed = 0
flag_usj10_passed = 0
flag_usj11_passed = 0
flag_usj12_passed = 0
flag_usj13_passed = 0
flag_usj14_passed = 0
flag_usj15_passed = 0
flag_usj16_passed = 0
flag_usj17_passed = 0
flag_usj18_passed = 0
flag_usj19_passed = 0
flag_usj20_passed = 0
flag_usj21_passed = 0
flag_usj22_passed = 0
flag_usj23_passed = 0
flag_usj24_passed = 0
flag_usj25_passed = 0
flag_usj26_passed = 0
flag_usj27_passed = 0
flag_usj28_passed = 0
flag_usj29_passed = 0
flag_usj30_passed = 0
flag_usj31_passed = 0
flag_usj32_passed = 0
flag_usj33_passed = 0
flag_usj34_passed = 0
flag_usj35_passed = 0
flag_usj36_passed = 0

usj1_trigger_x = -1487.781
usj1_trigger_y = -1044.546
usj1_trigger_z = 18.707
usj2_trigger_x = -1352.695
usj2_trigger_y = -755.212
usj2_trigger_z = 28.673
usj3_trigger_x = -1216.49  
usj3_trigger_y = -911.833
usj3_trigger_z = 19.0
usj4_trigger_x = -1252.139  
usj4_trigger_y = -1054.685
usj4_trigger_z = 22.016
usj5_trigger_x = -1551.685  
usj5_trigger_y = -1075.674
usj5_trigger_z = 19.121
usj6_trigger_x = -1595.712  
usj6_trigger_y = -1272.881
usj6_trigger_z = 19.068
usj7_trigger_x = -1553.337  
usj7_trigger_y = -1230.952
usj7_trigger_z = 17.194
usj8_trigger_x = -1340.022  
usj8_trigger_y = -998.257
usj8_trigger_z = 19.115
usj9_trigger_x = 24.721  
usj9_trigger_y = 897.801
usj9_trigger_z = 25.103
usj10_trigger_x = 317.2051
usj10_trigger_y = -223.2012
usj10_trigger_z = 42.3731
usj11_trigger_x = -674.345  
usj11_trigger_y = 1162.422
usj11_trigger_z = 29.916
usj12_trigger_x = -529.84  
usj12_trigger_y = 830.062
usj12_trigger_z = 98.717
usj13_trigger_x = -839.022  
usj13_trigger_y = 1153.526
usj13_trigger_z = 31.94
usj14_trigger_x = -312.447  
usj14_trigger_y = 1109.196
usj14_trigger_z = 47.741
usj15_trigger_x = -1011.583 
usj15_trigger_y = -30.098
usj15_trigger_z =  15.181
usj16_trigger_x = -942.702  
usj16_trigger_y = -114.506
usj16_trigger_z = 15.181
usj17_trigger_x = -900.789  
usj17_trigger_y = 260.804
usj17_trigger_z = 15.915
usj18_trigger_x = -1041.895  
usj18_trigger_y = -569.323
usj18_trigger_z = 21.855
usj25_trigger_x = -321.028
usj19_trigger_x = 208.993 
usj19_trigger_y = -963.672
usj19_trigger_z = 19.967
usj20_trigger_x = 46.115  
usj20_trigger_y = -964.415
usj20_trigger_z = 25.883
usj21_trigger_x = 435.8542
usj21_trigger_y = -334.3212
usj21_trigger_z = 15.8977
usj22_trigger_x = 110.481  
usj22_trigger_y = -1230.6
usj22_trigger_z = 35.67 
usj23_trigger_x = 7.435  
usj23_trigger_y = -1245.895
usj23_trigger_z = 17.752
usj24_trigger_x = 9.103  
usj24_trigger_y = -1326.505
usj24_trigger_z = 20.361
usj25_trigger_x = -321.028  
usj25_trigger_y = -1379.498
usj25_trigger_z = 10.929
usj26_trigger_x = -321.028  
usj26_trigger_y = -1276.589
usj26_trigger_z = 10.929
usj27_trigger_x = 218.05  
usj27_trigger_y = -1152.0
usj27_trigger_z = 12.84
usj28_trigger_x = 259.056  
usj28_trigger_y = -945.833
usj28_trigger_z = 12.84
usj29_trigger_x = 444.5  
usj29_trigger_y = -118.4
usj29_trigger_z = 16.0
usj30_trigger_x = 284.4732  
usj30_trigger_y = -494.1143
usj30_trigger_z = 16.0
usj31_trigger_x = 370.79 
usj31_trigger_y = -709.863
usj31_trigger_z = 19.895
usj32_trigger_x = 461.589  
usj32_trigger_y = -522.23
usj32_trigger_z = 18.931
usj33_trigger_x = 454.105  
usj33_trigger_y = -504.736
usj33_trigger_z = 18.931
usj34_trigger_x = 460.91  
usj34_trigger_y = -383.362
usj34_trigger_z = 14.222
usj35_trigger_x = 259.041  
usj35_trigger_y = -480.608
usj35_trigger_z = 14.688
usj36_trigger_x = -346.818
usj36_trigger_y = -290.741
usj36_trigger_z = 12.926

usj1_target_x = -1510.208 
usj1_target_y = -1042.849 
usj1_target_z = 32.151
usj2_target_x = -1353.033 
usj2_target_y = -806.455 
usj2_target_z = 39.2439
usj3_target_x = -1170.48 
usj3_target_y = -892.3815 
usj3_target_z = 34.0162
usj4_target_x = -1201.502 
usj4_target_y = -1013.937 
usj4_target_z = 23.4673 
usj5_target_x = -1511.204 
usj5_target_y = -1065.214 
usj5_target_z = 32.3439
usj6_target_x = -1548.072 
usj6_target_y = -1255.53 
usj6_target_z = 23.9858
usj7_target_x = -1598.12 
usj7_target_y = -1252.426 
usj7_target_z = 23.7824
usj8_target_x = -1363.207 
usj8_target_y = -996.5805 
usj8_target_z = 32.2555
usj9_target_x = -15.8172 
usj9_target_y = 907.157 
usj9_target_z = 28.9023
usj10_target_x = 309.8567 
usj10_target_y = -170.8791 
usj10_target_z = 20.3312
usj11_target_x = -673.2637 
usj11_target_y = 1209.819 
usj11_target_z = 32.8857
usj12_target_x = -529.3288 
usj12_target_y = 888.8258 
usj12_target_z = 77.5537 
usj13_target_x = -837.848 
usj13_target_y = 1200.585 
usj13_target_z = 25.7884
usj14_target_x = -335.0812 
usj14_target_y = 1055.352 
usj14_target_z = 47.3995
usj15_target_x = -1001.711 
usj15_target_y = -83.5744 
usj15_target_z = 22.2569
usj16_target_x = -881.2348 
usj16_target_y = -107.6016 
usj16_target_z = 20.23
usj17_target_x = -896.8717 
usj17_target_y = 235.2098 
usj17_target_z = 23.9347
usj18_target_x = -1038.943 
usj18_target_y = -599.2438 
usj18_target_z = 26.4899
usj19_target_x = 242.0566 
usj19_target_y = -963.7044 
usj19_target_z = 30.6993
usj20_target_x = 104.9159 
usj20_target_y = -964.5817 
usj20_target_z = 18.515
usj21_target_x = 427.7329 
usj21_target_y = -381.8485 
usj21_target_z = 18.9116
usj22_target_x = 106.3865 
usj22_target_y = -1279.522 
usj22_target_z = 40.51 
usj23_target_x = 11.7328 
usj23_target_y = -1306.691 
usj23_target_z = 25.3238
usj24_target_x = 11.7328 
usj24_target_y = -1371.335 
usj24_target_z = 19.3237
usj25_target_x = -320.9215 
usj25_target_y = -1430.599 
usj25_target_z = 16.8534
usj26_target_x = -320.6415 
usj26_target_y = -1310.957 
usj26_target_z = 17.6351
usj27_target_x = 225.9232 
usj27_target_y = -1101.189 
usj27_target_z = 20.9205
usj28_target_x = 246.7973 
usj28_target_y = -1007.525 
usj28_target_z = 22.6569
usj29_target_x = 394.259 
usj29_target_y = -116.6847 
usj29_target_z = 19.7462
usj30_target_x = 252.5868 
usj30_target_y = -477.8011 
usj30_target_z = 20.6179
usj31_target_x = 344.1249 
usj31_target_y = -748.2875 
usj31_target_z = 31.9164
usj32_target_x = 403.8112 
usj32_target_y = -510.4724 
usj32_target_z = 18.9753
usj33_target_x = 436.7198 
usj33_target_y = -555.8276 
usj33_target_z = 28.7096
usj34_target_x = 457.8847 
usj34_target_y = -413.2519 
usj34_target_z = 26.4187 
usj35_target_x = 290.986 
usj35_target_y = -497.1007 
usj35_target_z = 19.0179
usj36_target_x = -306.2269 
usj36_target_y = -290.804 
usj36_target_z = 22.1777

cash_reward_usj = 100
usj_number = 0
total_completed_usj = 0
do_usj_reward = 0

SET_DEATHARREST_STATE OFF
SET_UNIQUE_JUMPS_TOTAL 36

SCRIPT_NAME usj

practice_mode = 0

mission_start_usj:
WAIT 0

IF NOT IS_PLAYER_PLAYING player1
	GOTO mission_start_usj
ENDIF

IF flag_usj_off = 1
	GOTO mission_start_usj
ENDIF

IF NOT IS_PLAYER_IN_ANY_CAR player1
	GOTO mission_start_usj
ENDIF
	
IF IS_PLAYER_IN_ANY_BOAT player1
	GOTO mission_start_usj
ENDIF

IF IS_PLAYER_IN_FLYING_VEHICLE player1
	GOTO mission_start_usj
ENDIF



// Practice SCM - Toggle practice mode
IF IS_BUTTON_PRESSED 0 19 // Submission
	WAIT 100
	SWITCH practice_mode
		CASE 0
			practice_mode = 1
			BREAK
		CASE 1
			practice_mode = 0
			BREAK
	ENDSWITCH
ENDIF

// Practice SCM - USJ Practice Mode
GOTO zone_check

coronas:
	GOSUB airport_docks_havana_coronas
	GOSUB prawn_coronas
	GOSUB downtown_coronas
	GOSUB haiti_coronas
	GOSUB oceanbeach_docks_coronas
	GOSUB oceanbeach_coronas
	GOSUB oceanbeach_washingtonbeach_coronas
	GOSUB washingtonbeach_coronas
	GOSUB washingtonbeach_vicepoint_coronas
	GOSUB vicepoint_coronas
	GOSUB starfish_coronas
	RETURN

airport_docks_havana_coronas:
	DRAW_CORONA usj1_trigger_x usj1_trigger_y usj1_trigger_z 3.25 CORONATYPE_CIRCLE 0 255 127 0
	DRAW_CORONA usj2_trigger_x usj2_trigger_y usj2_trigger_z 3.25 CORONATYPE_CIRCLE 0 128 128 255
	DRAW_CORONA usj3_trigger_x usj3_trigger_y usj3_trigger_z 3.25 CORONATYPE_CIRCLE 0 0 255 0
	DRAW_CORONA usj4_trigger_x usj4_trigger_y usj4_trigger_z 3.25 CORONATYPE_CIRCLE 0 0 255 255
	DRAW_CORONA usj5_trigger_x usj5_trigger_y usj5_trigger_z 3.25 CORONATYPE_CIRCLE 0 255 0 0
	DRAW_CORONA usj6_trigger_x usj6_trigger_y usj6_trigger_z 3.25 CORONATYPE_CIRCLE 0 255 0 255
	DRAW_CORONA usj7_trigger_x usj7_trigger_y usj7_trigger_z 3.25 CORONATYPE_CIRCLE 0 255 255 0
	DRAW_CORONA usj8_trigger_x usj8_trigger_y usj8_trigger_z 3.25 CORONATYPE_CIRCLE 0 255 255 255
	DRAW_CORONA usj18_trigger_x usj18_trigger_y usj18_trigger_z 3.25 CORONATYPE_CIRCLE 0 135 66 245

	DRAW_CORONA usj1_target_x usj1_target_y usj1_target_z 10.0 CORONATYPE_RING 0 255 127 0
	DRAW_CORONA usj2_target_x usj2_target_y usj2_target_z 10.0 CORONATYPE_RING 0 128 128 255
	DRAW_CORONA usj3_target_x usj3_target_y usj3_target_z 10.0 CORONATYPE_RING 0 0 255 0
	DRAW_CORONA usj4_target_x usj4_target_y usj4_target_z 10.0 CORONATYPE_RING 0 0 255 255
	DRAW_CORONA usj5_target_x usj5_target_y usj5_target_z 10.0 CORONATYPE_RING 0 255 0 0
	DRAW_CORONA usj6_target_x usj6_target_y usj6_target_z 10.0 CORONATYPE_RING 0 255 0 255
	DRAW_CORONA usj7_target_x usj7_target_y usj7_target_z 10.0 CORONATYPE_RING 0 255 255 0
	DRAW_CORONA usj8_target_x usj8_target_y usj8_target_z 10.0 CORONATYPE_RING 0 255 255 255
	DRAW_CORONA usj18_target_x usj18_target_y usj18_target_z 10.0 CORONATYPE_RING 0 135 66 245
	RETURN

prawn_coronas:
	DRAW_CORONA usj9_trigger_x usj9_trigger_y usj9_trigger_z 3.25 CORONATYPE_CIRCLE 0 255 127 0
	DRAW_CORONA usj9_target_x usj9_target_y usj9_target_z 10.0 CORONATYPE_RING 0 255 127 0
	RETURN

downtown_coronas:
	DRAW_CORONA usj11_trigger_x usj11_trigger_y usj11_trigger_z 3.25 CORONATYPE_CIRCLE 0 255 127 0
	DRAW_CORONA usj12_trigger_x usj12_trigger_y usj12_trigger_z 3.25 CORONATYPE_CIRCLE 0 0 255 0
	DRAW_CORONA usj13_trigger_x usj13_trigger_y usj13_trigger_z 3.25 CORONATYPE_CIRCLE 0 255 0 0
	DRAW_CORONA usj14_trigger_x usj14_trigger_y usj14_trigger_z 3.25 CORONATYPE_CIRCLE 0 255 0 255

	DRAW_CORONA usj11_target_x usj11_target_y usj11_target_z 10.0 CORONATYPE_RING 0 255 127 0
	DRAW_CORONA usj12_target_x usj12_target_y usj12_target_z 10.0 CORONATYPE_RING 0 0 255 0
	DRAW_CORONA usj13_target_x usj13_target_y usj13_target_z 10.0 CORONATYPE_RING 0 255 0 0
	DRAW_CORONA usj14_target_x usj14_target_y usj14_target_z 10.0 CORONATYPE_RING 0 255 0 255
	RETURN

haiti_coronas:
	DRAW_CORONA usj15_trigger_x usj15_trigger_y usj15_trigger_z 3.25 CORONATYPE_CIRCLE 0 255 127 0
	DRAW_CORONA usj16_trigger_x usj16_trigger_y usj16_trigger_z 3.25 CORONATYPE_CIRCLE 0 0 255 0
	DRAW_CORONA usj17_trigger_x usj17_trigger_y usj17_trigger_z 3.25 CORONATYPE_CIRCLE 0 255 0 0

	DRAW_CORONA usj15_target_x usj15_target_y usj15_target_z 10.0 CORONATYPE_RING 0 255 127 0
	DRAW_CORONA usj16_target_x usj16_target_y usj16_target_z 10.0 CORONATYPE_RING 0 0 255 0
	DRAW_CORONA usj17_target_x usj17_target_y usj17_target_z 10.0 CORONATYPE_RING 0 255 0 0
	RETURN

oceanbeach_docks_coronas:
	DRAW_CORONA usj25_trigger_x usj25_trigger_y usj25_trigger_z 3.25 CORONATYPE_CIRCLE 0 255 127 0
	DRAW_CORONA usj26_trigger_x usj26_trigger_y usj26_trigger_z 3.25 CORONATYPE_CIRCLE 0 0 255 0

	DRAW_CORONA usj25_target_x usj25_target_y usj25_target_z 10.0 CORONATYPE_RING 0 255 127 0
	DRAW_CORONA usj26_target_x usj26_target_y usj26_target_z 10.0 CORONATYPE_RING 0 0 255 0
	RETURN

oceanbeach_coronas:
	DRAW_CORONA usj19_trigger_x usj19_trigger_y usj19_trigger_z 3.25 CORONATYPE_CIRCLE 0 255 127 0
	DRAW_CORONA usj20_trigger_x usj20_trigger_y usj20_trigger_z 3.25 CORONATYPE_CIRCLE 0 0 255 0
	DRAW_CORONA usj22_trigger_x usj22_trigger_y usj22_trigger_z 3.25 CORONATYPE_CIRCLE 0 255 0 0
	DRAW_CORONA usj23_trigger_x usj23_trigger_y usj23_trigger_z 3.25 CORONATYPE_CIRCLE 0 255 0 255
	DRAW_CORONA usj24_trigger_x usj24_trigger_y usj24_trigger_z 3.25 CORONATYPE_CIRCLE 0 0 255 128
	DRAW_CORONA usj27_trigger_x usj27_trigger_y usj27_trigger_z 3.25 CORONATYPE_CIRCLE 0 255 255 255

	DRAW_CORONA usj19_target_x usj19_target_y usj19_target_z 10.0 CORONATYPE_RING 0 255 127 0
	DRAW_CORONA usj20_target_x usj20_target_y usj20_target_z 10.0 CORONATYPE_RING 0 0 255 0
	DRAW_CORONA usj22_target_x usj22_target_y usj22_target_z 10.0 CORONATYPE_RING 0 255 0 0
	DRAW_CORONA usj23_target_x usj23_target_y usj23_target_z 10.0 CORONATYPE_RING 0 255 0 255
	DRAW_CORONA usj24_target_x usj24_target_y usj24_target_z 10.0 CORONATYPE_RING 0 0 255 128
	DRAW_CORONA usj27_target_x usj27_target_y usj27_target_z 10.0 CORONATYPE_RING 0 255 255 255
	RETURN

oceanbeach_washingtonbeach_coronas:
	DRAW_CORONA usj28_trigger_x usj28_trigger_y usj28_trigger_z 3.25 CORONATYPE_CIRCLE 0 128 128 255
	DRAW_CORONA usj28_target_x usj28_target_y usj28_target_z 10.0 CORONATYPE_RING 0 128 128 255
	RETURN

washingtonbeach_coronas:
	DRAW_CORONA usj30_trigger_x usj30_trigger_y usj30_trigger_z 3.25 CORONATYPE_CIRCLE 0 255 127 0
	DRAW_CORONA usj31_trigger_x usj31_trigger_y usj31_trigger_z 3.25 CORONATYPE_CIRCLE 0 0 255 0
	DRAW_CORONA usj32_trigger_x usj32_trigger_y usj32_trigger_z 3.25 CORONATYPE_CIRCLE 0 255 0 0
	DRAW_CORONA usj33_trigger_x usj33_trigger_y usj33_trigger_z 3.25 CORONATYPE_CIRCLE 0 255 0 255
	DRAW_CORONA usj35_trigger_x usj35_trigger_y usj35_trigger_z 3.25 CORONATYPE_CIRCLE 0 255 127 0

	DRAW_CORONA usj30_target_x usj30_target_y usj30_target_z 10.0 CORONATYPE_RING 0 255 127 0
	DRAW_CORONA usj31_target_x usj31_target_y usj31_target_z 10.0 CORONATYPE_RING 0 0 255 0
	DRAW_CORONA usj32_target_x usj32_target_y usj32_target_z 10.0 CORONATYPE_RING 0 255 0 0
	DRAW_CORONA usj33_target_x usj33_target_y usj33_target_z 10.0 CORONATYPE_RING 0 255 0 255
	DRAW_CORONA usj35_target_x usj35_target_y usj35_target_z 10.0 CORONATYPE_RING 0 255 127 0
	RETURN

washingtonbeach_vicepoint_coronas:
	DRAW_CORONA usj21_trigger_x usj21_trigger_y usj21_trigger_z 3.25 CORONATYPE_CIRCLE 0 255 0 0
	DRAW_CORONA usj34_trigger_x usj34_trigger_y usj34_trigger_z 3.25 CORONATYPE_CIRCLE 0 255 255 255

	DRAW_CORONA usj21_target_x usj21_target_y usj21_target_z 10.0 CORONATYPE_RING 0 255 0 0
	DRAW_CORONA usj34_target_x usj34_target_y usj34_target_z 10.0 CORONATYPE_RING 0 255 255 255
	RETURN

vicepoint_coronas:
	DRAW_CORONA usj10_trigger_x usj10_trigger_y usj10_trigger_z 3.25 CORONATYPE_CIRCLE 0 255 127 0
	DRAW_CORONA usj29_trigger_x usj29_trigger_y usj29_trigger_z 3.25 CORONATYPE_CIRCLE 0 0 255 0

	DRAW_CORONA usj10_target_x usj10_target_y usj10_target_z 10.0 CORONATYPE_RING 0 255 127 0
	DRAW_CORONA usj29_target_x usj29_target_y usj29_target_z 10.0 CORONATYPE_RING 0 0 255 0
	RETURN

starfish_coronas:
	DRAW_CORONA usj36_trigger_x usj36_trigger_y usj36_trigger_z 3.25 CORONATYPE_CIRCLE 0 255 0 255
	DRAW_CORONA usj36_target_x usj36_target_y usj36_target_z 10.0 CORONATYPE_RING 0 255 0 255
	RETURN

zone_check:
IF IS_PLAYER_IN_ZONE player1 A_PORT
	IF practice_mode = 1
		GOSUB airport_docks_havana_coronas
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 -1487.781 -1044.546 18.707 3.5 3.0 3.0 0//OVER WESTERN BOARDING TUNNEL FROM EAST*
		usj_number = 1
		camera_x = -1521.9639  
		camera_y = -1039.8505
		camera_z = 24.1338
		usj_target_x = -1510.2076
		usj_target_y = -1042.8491
		usj_target_z = 32.1510 
		GOTO the_jump
	ENDIF

	IF LOCATE_PLAYER_IN_CAR_3D player1 -1352.695 -755.212 28.673 2.0 4.0 4.0 0//JUMP ONTO TERMINAL ROOF FROM SURFER DUDE BILL BOARD*
		usj_number = 2
		camera_x = -1360.8242  
		camera_y = -781.5606 
		camera_z = 37.2329
		usj_target_x = -1353.0330
		usj_target_y = -806.4550 
		usj_target_z = 39.2439 
		GOTO the_jump
	ENDIF

	IF LOCATE_PLAYER_IN_CAR_3D player1 -1216.49 -911.833 19.0 2.5 2.5 3.0 0//BOARDING STAIRS OVER ROAD ONTO BUILDING*
		usj_number = 3
		camera_x = -1200.2438 
		camera_y = -894.1972 
		camera_z = 26.7296
		usj_target_x = -1170.4802
		usj_target_y = -892.3815 
		usj_target_z = 34.0162 
		GOTO the_jump
	ENDIF

	IF LOCATE_PLAYER_IN_CAR_3D player1 -1252.139 -1054.685 22.016 4.0 4.0 3.0 0//HUGE RAMP AT END OF RUNWAY ONTO ROAD*
		usj_number = 4
		camera_x = -1194.2791
		camera_y = -1027.8624
		camera_z = 22.9790
		usj_target_x = -1201.5020
		usj_target_y = -1013.9373
		usj_target_z = 23.4673 
		GOTO the_jump
	ENDIF

	IF LOCATE_PLAYER_IN_CAR_3D player1 -1551.685 -1075.674 19.121 3.5 2.5 2.5 0//OVER WESTERN BOARDING TUNNEL FROM WEST*
		usj_number = 5
		camera_x = -1520.1648 
		camera_y = -1073.3604 
		camera_z = 24.1604
		usj_target_x = -1511.2036
		usj_target_y = -1065.2136
		usj_target_z = 32.3439 
		GOTO the_jump
	ENDIF
	
	IF LOCATE_PLAYER_IN_CAR_3D player1 -1595.712 -1272.881 19.068 3.0 3.0 2.5 0//OVER RED RADAR BUILDING FROM BORADING STAIRS*
		usj_number = 6
		camera_x =  -1564.4539
		camera_y =  -1271.5879
		camera_z = 21.5915
		usj_target_x = -1548.0720
		usj_target_y = -1255.5304
		usj_target_z = 23.9858 
		GOTO the_jump
	ENDIF
	
	IF LOCATE_PLAYER_IN_CAR_3D player1 -1553.337 -1230.952 17.194 3.0 3.0 2.5 0//OVER RED RADAR BUILDING FROM SIGN*
		usj_number = 7
		camera_x = -1590.5802
		camera_y = -1247.3733
		camera_z = 26.3087   
		usj_target_x = -1598.1204
		usj_target_y = -1252.4260
		usj_target_z = 23.7824 
		GOTO the_jump
	ENDIF
	
	IF LOCATE_PLAYER_IN_CAR_3D player1 -1340.022 -998.257 19.115 3.0 3.0 3.0 0//OVER EASTERN BOARDING TUNNEL*
		usj_number = 8
		camera_x = -1355.2749 
		camera_y = -997.9999 
		camera_z = 24.0731
		usj_target_x = -1363.2073
		usj_target_y = -996.5805 
		usj_target_z = 32.2555 
		GOTO the_jump
	ENDIF
ENDIF

IF IS_PLAYER_IN_ZONE player1 PORNI
	IF practice_mode = 1
		GOSUB prawn_coronas
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 24.721 897.801 25.103 3.0 3.5 2.5 0//FROM ROOF INTO PORN STUDIO*
		usj_number = 9
		camera_x = 0.1404 
		camera_y = 878.4036 
		camera_z = 20.2009
		usj_target_x = -15.8172
		usj_target_y = 907.1570
		usj_target_z = 28.9023 
		GOTO the_jump
	ENDIF
ENDIF

IF IS_PLAYER_IN_ZONE player1 DOCKS
	IF practice_mode = 1
		GOSUB airport_docks_havana_coronas
		GOSUB oceanbeach_docks_coronas
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 -321.028 -1379.498 10.929 4.0 4.0 3.0 0//COLONELS JETTY SOUTH*
		usj_number = 25
		camera_x = -311.0497 
		camera_y = -1399.5061
		camera_z = 9.6779
		usj_target_x = -320.9215 
		usj_target_y = -1430.5988
		usj_target_z = 16.8534 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 -321.028 -1276.589 10.929 4.0 4.0 3.0 0//COLONELS JETTY*
		usj_number = 26
		camera_x = -314.5936 
		camera_y = -1300.2806
		camera_z = 9.4204
		usj_target_x = -320.6415 
		usj_target_y = -1310.9570
		usj_target_z = 17.6351 
		GOTO the_jump
	ENDIF
ENDIF

IF IS_PLAYER_IN_ZONE player1 DTOWN
	IF practice_mode = 1
		GOSUB downtown_coronas
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 -674.345 1162.422 29.916 2.5 4.0 2.5 0//INFRONT OF AMMU UP STAIRS OVER STREET INTO HOG TIED*
		usj_number = 11
		camera_x = -690.7014 
		camera_y = 1199.2126   
		camera_z = 25.0565
		usj_target_x = -673.2637
		usj_target_y = 1209.8191
		usj_target_z = 32.8857 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 -529.84 830.062 98.717 7.0 3.0 3.0 0//OUT OF HIGHRISE INTO HOLE IN OPPOSIT HIGHRISE*
		usj_number = 12
		camera_x = -543.2 
		camera_y = 843.4   
		camera_z = 99.2
		usj_target_x = -529.3288
		usj_target_y = 888.8258 
		usj_target_z = 77.5537 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 -839.022 1153.526 31.94 3.7 2.5 2.5 0//G-SPOT OVER STREET FROM HOSPITAL*
		usj_number = 13
		camera_x = -853.7 
		camera_y = 1172.3   
		camera_z = 24.4
		usj_target_x = -837.8480
		usj_target_y = 1200.5847
		usj_target_z = 25.7884 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 -312.447 1109.196 47.741 5.0 3.0 2.5 0//ON TO THE ROOF WITH THE G-SPOTLIGHT*
		usj_number = 14
		camera_x = -292.5 
		camera_y = 1102.7   
		camera_z = 40.0
		usj_target_x = -335.0812
		usj_target_y = 1055.3518
		usj_target_z = 47.3995 
		GOTO the_jump
	ENDIF
ENDIF

IF IS_PLAYER_IN_ZONE player1 HAITI
	IF practice_mode = 1
		GOSUB haiti_coronas
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 -1011.583 -30.098 15.181 2.5 2.5 2.5 0//WOODEN RAMP BEHIND SHITTY LITTLE BUILDINGS NEAR AUNTIE*
		usj_number = 15
		camera_x = -1004.1540 
		camera_y = -62.9943   
		camera_z = 15.9570
		usj_target_x = -1001.7108
		usj_target_y = -83.5744 
		usj_target_z = 22.2569 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 -942.702 -114.506 15.181 2.5 2.5 2.5 0// OVER DRIED OUT CANAL/AQUADUCT*
		usj_number = 16
		camera_x = -930.7841 
		camera_y = -125.4432   
		camera_z = 12.2188
		usj_target_x = -881.2348
		usj_target_y = -107.6016
		usj_target_z = 20.2300 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 -900.789 260.804 15.915 2.5 2.5 2.5 0//ONTO ROOF WITH HAITI HELI CHECKPOINT*
		usj_number = 17
		camera_x = -906.6896 
		camera_y = 238.6932 
		camera_z = 16.5044
		usj_target_x = -896.8717
		usj_target_y = 235.2098 
		usj_target_z = 23.9347 
		GOTO the_jump
	ENDIF
ENDIF

IF IS_PLAYER_IN_ZONE player1 HAVANA
	IF practice_mode = 1
		GOSUB airport_docks_havana_coronas
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 -1041.895 -569.323 21.855 5.0 2.5 2.5 0//JUMP ACROSS THE STREET FROM THE ROOF - EAST FROM THE CUBANS PLACE*
		usj_number = 18
		camera_x = -1055.6156
		camera_y = -588.8613  
		camera_z = 18.1929
		usj_target_x = -1038.9431
		usj_target_y = -599.2438 
		usj_target_z = 26.4899 
		GOTO the_jump
	ENDIF
ENDIF

IF IS_PLAYER_IN_ZONE player1 BEACH1 // OCEAN BEACH
	IF practice_mode = 1
		GOSUB oceanbeach_coronas
		GOSUB oceanbeach_docks_coronas
		GOSUB oceanbeach_washingtonbeach_coronas
	ENDIF

	IF LOCATE_PLAYER_IN_CAR_3D player1 208.993 -963.672 19.967 2.5 2.5 2.5 0//JUMP FROM THE MALL ACROSS ROAD AND ROOF OFF VENTS*
	//OR LOCATE_PLAYER_IN_CAR_3D player1 205.927 -975.297 19.967 2.5 2.5 2.5 0
		usj_number = 19
		camera_x = 233.5752 //209.0673 
		camera_y = -960.8961 //-980.8854 
		camera_z = 21.5283 //19.5373
		usj_target_x = 242.0566 
		usj_target_y = -963.7044
		usj_target_z = 30.6993 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 46.115 -964.415 25.883 2.5 3.5 2.5 0//MALL*
		usj_number = 20
		camera_x = 63.3356 
		camera_y = -967.6796 
		camera_z = 26.3317
		usj_target_x = 104.9159 
		usj_target_y = -964.5817
		usj_target_z = 18.515 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 110.481 -1230.6 35.67 4.0 4.0 2.5 0//OUT OF THE MULTISTOREY CARPARK*
		usj_number = 22
		camera_x = 84.5247 
		camera_y = -1258.389
		camera_z = 31.4335
		usj_target_x = 106.3865 
		usj_target_y = -1279.5221
		usj_target_z = 40.5100  
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 7.435 -1245.895 17.752 3.0 3.0 3.5 0//GAS STATION*
		usj_number = 23
		camera_x = 4.1501 
		camera_y = -1274.4602
		camera_z = 19.7525
		usj_target_x = 11.7328 
		usj_target_y = -1306.6909
		usj_target_z = 25.3238 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 9.103 -1326.505 20.361 3.0 3.0 2.5 0//PINK ROOF SOUTH FROM GAS STATION*
		usj_number = 24
		camera_x = -6.4837  
		camera_y = -1355.1759
		camera_z = 20.0450
		usj_target_x = 11.7328 
		usj_target_y = -1371.3351
		usj_target_z = 19.3237 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 -321.028 -1379.498 10.929 4.0 4.0 3.0 0//COLONELS JETTY SOUTH*
		usj_number = 25
		camera_x = -311.0497 
		camera_y = -1399.5061
		camera_z = 9.6779
		usj_target_x = -320.9215 
		usj_target_y = -1430.5988
		usj_target_z = 16.8534 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 -321.028 -1276.589 10.929 4.0 4.0 3.0 0//COLONELS JETTY*
		usj_number = 26
		camera_x = -314.5936 
		camera_y = -1300.2806
		camera_z = 9.4204
		usj_target_x = -320.6415 
		usj_target_y = -1310.9570
		usj_target_z = 17.6351 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 218.05 -1152.0 12.84 2.5 2.0 2.5 0//PALLETS OVER WIDE ALLEY BEHIND OCEAN DRIVE*
		usj_number = 27
		camera_x = 228.2427
		camera_y = -1140.7739
		camera_z = 14.4116
		usj_target_x = 225.9232 
		usj_target_y = -1101.1895
		usj_target_z = 20.9205 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 259.056 -945.833 12.84 2.5 2.0 2.0 0//PALLETS OVER ROAD BEHIND OCEAN DRIVE*
		usj_number = 28
		camera_x = 259.0203
		camera_y = -963.3474
		camera_z = 10.0962
		usj_target_x = 246.7973 
		usj_target_y = -1007.5247
		usj_target_z = 22.6569 
		GOTO the_jump
	ENDIF
ENDIF

IF IS_PLAYER_IN_ZONE player1 BEACH2 // Washington Beach
	IF practice_mode = 1
		GOSUB oceanbeach_washingtonbeach_coronas
		GOSUB washingtonbeach_coronas
		GOSUB washingtonbeach_vicepoint_coronas
	ENDIF

	IF LOCATE_PLAYER_IN_CAR_3D player1 284.4732 -494.1143 16.0 3.0 3.0 3.0 0 //DIRT MOUND IN CARPARK OVER RIVER BY COPSHOP*
		usj_number = 30
		camera_x = 268.9545 
		camera_y = -469.6216  
		camera_z = 15.2438 
		usj_target_x = 252.5868 
		usj_target_y = -477.8011
		usj_target_z = 20.6179 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 370.79 -709.863 19.895 3.0 3.0 3.0 0//UP STAIRS IN ALLEY BEHIND OCEAN DRIVE*
		usj_number = 31
		camera_x = 361.3011
		camera_y = -735.6794
		camera_z = 23.4501
		usj_target_x = 344.1249 
		usj_target_y = -748.2875
		usj_target_z = 31.9164 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 461.589 -522.23 18.931 3.0 3.0 3.0 0//STAIRS GOING WEST AT GUARDIAN ANGELS*
		usj_number = 32
		camera_x = 426.6392
		camera_y = -524.0469
		camera_z = 12.3656
		usj_target_x = 403.8112 
		usj_target_y = -510.4724
		usj_target_z = 18.9753 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 454.105 -504.736 18.931 3.0 3.0 3.0 0//STAIRS GOING SOUTH AT GARDIAN ANGEL*
		usj_number = 33
		camera_x = 456.6417
		camera_y = -532.0921
		camera_z = 19.3283
		usj_target_x = 436.7198 
		usj_target_y = -555.8276
		usj_target_z = 28.7096 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 460.91 -383.362 14.222 3.0 3.0 3.0 0//WOODEN RAMP AT END OF BUILDINGS SOUTH FROM MALIBU*
		usj_number = 34
		camera_x = 462.6722
		camera_y = -399.8143
		camera_z = 17.5715
		usj_target_x = 457.8847 
		usj_target_y = -413.2519
		usj_target_z = 26.4187 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 259.041 -480.608 14.688 4.0 5.0 4.0 0 //OVER RIVER NEXT TO COP SHOP*
		usj_number = 35
		camera_x = 282.5344
		camera_y = -479.8412
		camera_z = 10.4141
		usj_target_x = 290.9860 
		usj_target_y = -497.1007
		usj_target_z = 19.0179 
		GOTO the_jump
	ENDIF
ENDIF

IF IS_PLAYER_IN_ZONE player1 BEACH3 // Vice Point
	IF practice_mode = 1
		GOSUB washingtonbeach_vicepoint_coronas
		GOSUB vicepoint_coronas
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 317.2051 -223.2012 42.3731 2.6 3.6 2.6 0//OFF THE TOP OF THE BUILDING SITE*
		usj_number = 10
		camera_x = 301.9448
		camera_y = -215.9068  
		camera_z = 34.4501
		usj_target_x = 309.8567 
		usj_target_y = -170.8791
		usj_target_z = 20.3312 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 444.5 -118.4 16.0 3.0 3.0 3.0 0//MALIBU*
		usj_number = 29
		camera_x = 416.4033  
		camera_y = -125.6725 
		camera_z = 13.7649
		usj_target_x = 394.2590 
		usj_target_y = -116.6847
		usj_target_z = 19.7462  
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 435.8542 -334.3212 15.8977 3.0 3.0 3.0 0//SOUTH DOWN ROAD FROM MALIBU OVER BRIDGE*
		usj_number = 21
		camera_x = 420.6179
		camera_y = -367.5033 
		camera_z = 14.1343
		usj_target_x = 427.7329 
		usj_target_y = -381.8485
		usj_target_z = 18.9116 
		GOTO the_jump
	ENDIF
ENDIF

IF IS_PLAYER_IN_ZONE player1 STARI
	IF practice_mode = 1
		GOSUB starfish_coronas
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 -346.818 -290.741 12.926 3.0 3.0 3.0 0//IN GARDEN UP STAIRS*
		usj_number = 36
		camera_x = -317.0066
		camera_y = -298.7890
		camera_z = 15.3976
		usj_target_x = -306.2269
		usj_target_y = -290.8040
		usj_target_z = 22.1777 
		GOTO the_jump
	ENDIF
ENDIF

GOTO mission_start_usj

the_jump:
STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 players_car_usj
GET_CAR_SPEED players_car_usj car_speed_usj

IF NOT IS_CAR_IN_AIR_PROPER players_car_usj
	GOTO mission_start_usj
ENDIF

IF car_speed_usj < 25.0
	GOTO mission_start_usj
ENDIF

collision_counter_usj = 0
do_usj_reward = 0

//GET_PLAYER_COORDINATES player1 usj_target_x usj_target_y usj_target_z
SET_TIME_SCALE 0.3
slomo = 1
SET_FIXED_CAMERA_POSITION camera_x camera_y camera_z 0.0 0.0 0.0
POINT_CAMERA_AT_CAR players_car_usj FIXED JUMP_CUT

WHILE IS_CAR_IN_AIR_PROPER players_car_usj
OR collision_counter_usj < 10
	++ collision_counter_usj
	
	WAIT 0
	IF practice_mode = 1
		GOSUB coronas
	ENDIF
	IF IS_CAR_DEAD players_car_usj
		usj_jump_dist = 0.0
		GOTO camera_restore
	ENDIF
	
	IF IS_CAR_IN_WATER players_car_usj
		usj_jump_dist = 0.0
		GOTO camera_restore
	ENDIF
	
	IF NOT IS_PLAYER_PLAYING player1
		usj_jump_dist = 0.0
		GOTO camera_restore
	ENDIF

	IF NOT IS_PLAYER_IN_ANY_CAR player1
		usj_jump_dist = 0.0
		GOTO camera_restore
	ENDIF

	IF do_usj_reward = 0
		IF LOCATE_PLAYER_IN_CAR_3D player1 usj_target_x usj_target_y usj_target_z 10.0 10.0 10.0 0
			do_usj_reward = 1
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 10 // Race start sound to indicate "good"
		ENDIF
	ENDIF
	
ENDWHILE

//GET_PLAYER_COORDINATES player1 usj_end_x usj_end_y usj_end_z
//GET_DISTANCE_BETWEEN_COORDS_3D usj_target_x usj_target_y usj_target_z usj_end_x usj_end_y usj_end_z usj_jump_dist

camera_restore:
WAIT 300
SET_TIME_SCALE 1.0
RESTORE_CAMERA_JUMPCUT

IF practice_mode = 1
	IF do_usj_reward = 1
		GOTO usj_complete
	ENDIF
ENDIF


IF do_usj_reward = 1//usj_jump_dist > 20.0
	IF usj_number = 1 
	AND flag_usj1_passed = 0
		flag_usj1_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 2
	AND flag_usj2_passed = 0
		flag_usj2_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 3
	AND flag_usj3_passed = 0
		flag_usj3_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 4
	AND flag_usj4_passed = 0
		flag_usj4_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 5
	AND flag_usj5_passed = 0
		flag_usj5_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 6
	AND flag_usj6_passed = 0
		flag_usj6_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 7
	AND flag_usj7_passed = 0
		flag_usj7_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 8
	AND flag_usj8_passed = 0
		flag_usj8_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 9
	AND flag_usj9_passed = 0
		flag_usj9_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 10
	AND flag_usj10_passed = 0
		flag_usj10_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 11
	AND flag_usj11_passed = 0
		flag_usj11_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 12
	AND flag_usj12_passed = 0
		flag_usj12_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 13
	AND flag_usj13_passed = 0
		flag_usj13_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 14
	AND	flag_usj14_passed = 0
		flag_usj14_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 15
	AND flag_usj15_passed = 0
		flag_usj15_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 16
	AND	flag_usj16_passed = 0
		flag_usj16_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 17
	AND	flag_usj17_passed = 0
		flag_usj17_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 18
	AND flag_usj18_passed = 0
		flag_usj18_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 19
	AND flag_usj19_passed = 0
		flag_usj19_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 20
	AND flag_usj20_passed = 0
		flag_usj20_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 21
	AND flag_usj21_passed = 0
		flag_usj21_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 22
	AND flag_usj22_passed = 0
		flag_usj22_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 23
	AND flag_usj23_passed = 0
		flag_usj23_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 24
	AND	flag_usj24_passed = 0
		flag_usj24_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 25
	AND flag_usj25_passed = 0
		flag_usj25_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 26
	AND flag_usj26_passed = 0
		flag_usj26_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 27
	AND flag_usj27_passed = 0
		flag_usj27_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 28
	AND flag_usj28_passed = 0
		flag_usj28_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 29
	AND flag_usj29_passed = 0
		flag_usj29_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 30
	AND flag_usj30_passed = 0
		flag_usj30_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 31
	AND flag_usj31_passed = 0
		flag_usj31_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 32
	AND flag_usj32_passed = 0
		flag_usj32_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 33
	AND flag_usj33_passed = 0
		flag_usj33_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 34
	AND	flag_usj34_passed = 0
		flag_usj34_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 35
	AND flag_usj35_passed = 0
		flag_usj35_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF

	IF usj_number = 36
	AND flag_usj36_passed = 0
		flag_usj36_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO usj_complete
	ENDIF
ENDIF

GOTO mission_start_usj

usj_complete:
 PRINT_BIG_Q USJ 5000 5 //UNIQUE STUNT BONUS!
 IF practice_mode = 1
	GOTO usj_finishingup
ENDIF

usj_reward:
IF total_completed_usj < 36
	PRINT_WITH_NUMBER_BIG REWARD cash_reward_usj 6000 6
	ADD_SCORE player1 cash_reward_usj
	cash_reward_usj += 100
ELSE
	PRINT_BIG_Q USJ 5000 5 //UNIQUE STUNT BONUS!
	PRINT_HELP USJ_ALL //ALL UNIQUE STUNTS COMPLETED!
	PRINT_WITH_NUMBER_BIG REWARD 10000 6000 6
	ADD_SCORE player1 10000
ENDIF

usj_finishingup:
do_usj_reward = 0
ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE

REGISTER_UNIQUE_JUMP_FOUND
GOTO mission_start_usj

MISSION_END










//ESCOBAR INTERNATIONAL
//-1487.781 -1044.546 18.707//OVER WESTERN BOARDING TUNNEL FROM EAST*
//-1352.695 -755.212 28.673//JUMP ONTO TERMINAL ROOF FROM SURFER DUDE BILL BOARD*
//-1216.49 -911.833 19.0//BOARDING STAIRS OVER ROAD ONTO BUILDING*
//-1252.139 -1054.685 22.016//HUGE RAMP AT END OF RUNWAY ONTO ROAD*
//-1551.685 -1075.674 19.121//OVER WESTERN BOARDING TUNNEL FROM WEST*
//-1595.712 -1272.881 19.068//OVER RED RADAR BUILDING FROM BORADING STAIRS*
//-1553.337 -1230.952 17.194//OVER RED RADAR BUILDING FROM SIGN*
//-1340.022 -998.257 19.115//OVER EASTERN BOARDING TUNNEL*
//
//PRAWN ISLAND
//24.721 897.801 25.103//FROM ROOF INTO PORN STUDIO*
//
//DOWNTOWN
//-674.345 1162.422 29.916//INFRONT OF AMMU UP STAIRS OVER STREET INTO HOG TIED*
//-529.84 830.062 98.717//OUT OF HIGHRISE INTO HOLE IN OPPOSIT HIGHRISE*
//-839.022 1153.526 31.94//G-SPOT OVER STREET FROM HOSPITAL*
//-312.447 1109.196 47.741//ON TO THE ROOF WITH THE G-SPOTLIGHT*
//
//LITTLE HAITI
//-1011.583 -30.098 15.181//WOODEN RAMP BEHIND SHITTY LITTLE BUILDINGS NEAR AUNTIE*
//-942.702 -114.506 15.181// OVER DRIED OUT CANAL/AQUADUCT*
//-900.789 260.804 15.915//ONTO ROOF WITH HAITI HELI CHECKPOINT*
//
//LITTEL HAVANA
//-1041.895 -569.323 21.855//JUMP ACROSS THE STREET FROM THE ROOF - EAST FROM THE CUBANS PLACE*
//
//OCEAN BEACH
//208.993 -963.672 19.967//JUMP FROM THE MALL ACROSS ROAD AND ROOF OFF VENTS*
//46.115 -964.415 25.883//MALL*
//110.481 -1230.6 35.67//OUT OF THE MULTISTOREY CARPARK*
//7.435 -1245.895 17.752//GAS STATION*
//9.103 -1326.505 20.361//PINK ROOF SOUTH FROM GAS STATION*
//-321.028 -1379.498 10.93//COLONELS JETTY SOUTH*
//-321.028 -1276.589 10.93//COLONELS JETTY*
//218.05 -1152.0 12.84//PALLETS OVER WIDE ALLEY BEHIND OCEAN DRIVE*
//259.056 -945.833 12.8//PALLETS OVER ROAD BEHIND OCEAN DRIVE*
//
//WASHNGTON BEACH
//284.4732 -494.1143 16.0//DIRT MOUND IN CARPARK OVER RIVER BY COPSHOP*
//370.79 -709.863 19.895//UP STAIRS IN ALLEY BEHIND OCEAN DRIVE*
//461.589 -522.23 18.931//STAIRS GOING WEST AT GUARDIAN ANGELS*
//454.105 -504.736 18.931//STAIRS GOING SOUTH AT GARDIAN ANGEL*
//460.91 -383.362 14.222//WOODEN RAMP AT END OF BUILDINGS SOUTH FROM MALIBU*
//259.041 -480.608 14.688//OVER RIVER NEXT TO COP SHOP*
//
//VICE POINT
//317.2051 -223.2012 42.3731//OFF THE TOP OF THE BUILDING SITE*
//444.5 -118.4 16.0//MALIBU*
//435.8542 -334.3212 15.8977//SOUTH DOWN ROAD FROM MALIBU OVER BRIDGE*
//
//STARFISH ISLAND
//-346.818 -290.741 12.926//IN GARDEN UP STAIRS*










