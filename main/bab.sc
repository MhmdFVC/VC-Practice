MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *************************************Lawyer mission 2**************************************
// **************************************BACK ALLEY BRAWL***************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff

GOSUB mission_start_lawyer2

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_lawyer2_failed
ENDIF

GOSUB mission_cleanup_lawyer2

MISSION_END

{
// Variables for mission
VAR_INT played_buddy_sample1 ran_to_last_coords buddycar_blip_active played_sprint_help	any_bike_lawyer2
VAR_INT ambush_bloke1 ambush_bloke2 ambush_bloke3 ambush_bloke4 ambush_bloke5 ambush_bloke6 ambush_bloke7
VAR_INT ambush_bloke1_dead ambush_bloke2_dead ambush_bloke3_dead ambush_bloke4_dead ambush_bloke5_dead 
VAR_INT ambush_bloke6_dead ambush_bloke7_dead buddycar_blip	chef_cut_scene first_part_of_chef_cut drove_in_from_south
VAR_FLOAT blokeX blokeY blokeZ bud_Heading
LVAR_INT cs_bounca cs_ganga cs_gangb cs_gangc hotel_blip set_buddys_threat short_malibu_cut gun_blip_help
LVAR_INT ambush_blokes_obj_set cs_guncolt players_cellphone players_cellphone_blip on_the_phone_again
LVAR_INT set_players_control_back_on counter_badguys kent_paul1

// ***************************************Mission Start*************************************

mission_start_lawyer2:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
view_of_ocean_view = 0
SCRIPT_NAME LAWYER2
WAIT 0

LOAD_MISSION_TEXT LAWYER2
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION 110.6 -824.2 9.6 327.9

counter_badguys = 0
ambush_bloke1_dead = 0
ambush_bloke2_dead = 0
ambush_bloke3_dead = 0
ambush_bloke4_dead = 0
ambush_bloke5_dead = 0
ambush_bloke6_dead = 0
ambush_bloke7_dead = 0
played_buddy_sample1 = 0
first_two_samples = 0
second_two_samples = 0
audio_is_loading = 0
audio_has_loaded = 0
set_buddys_threat = 0
ran_to_last_coords = 0
buddy_blip_active = 0
blokeX = 433.7
blokeY = -575.9
blokeZ = 9.7
short_malibu_cut = 0
buddycar_blip_active = 0
chef_cut_scene = 0
first_part_of_chef_cut = 0
ambush_blokes_obj_set = 0
on_the_phone_again = 0
gun_blip_help = 0
set_players_control_back_on = 0
played_sprint_help = 0
drove_in_from_south = 0


CLEAR_HELP


SET_AREA_VISIBLE  VIS_LAWYERS 

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSken

LOAD_SPECIAL_MODEL CUTOBJ01 lwchara
LOAD_SPECIAL_MODEL CUTOBJ02 lwcharb
LOAD_SPECIAL_MODEL CUTOBJ03 lcfan
LOAD_SPECIAL_MODEL CUTOBJ04 lawdoor

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED CUTOBJ01
OR NOT HAS_MODEL_LOADED CUTOBJ02
OR NOT HAS_MODEL_LOADED CUTOBJ03
OR NOT HAS_MODEL_LOADED CUTOBJ04
	WAIT 0

ENDWHILE

LOAD_SCENE 140.6 -1367.4 13.1

LOAD_CUTSCENE law_2a
SET_CUTSCENE_OFFSET 141.441 -1366.722 12.163
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_ken
SET_CUTSCENE_ANIM cs_ken CSken

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_lwchara
SET_CUTSCENE_ANIM cs_lwchara lwchara

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_lwcharb
SET_CUTSCENE_ANIM cs_lwcharb lwcharb

CREATE_CUTSCENE_OBJECT CUTOBJ03 cs_lcfan
SET_CUTSCENE_ANIM_TO_LOOP lcfan
SET_CUTSCENE_ANIM cs_lcfan lcfan

CREATE_CUTSCENE_OBJECT CUTOBJ04 cs_lawdoor
SET_CUTSCENE_ANIM cs_lawdoor lawdoor

CLEAR_AREA 119.0 -826.8 9.8 0.5 TRUE
SET_PLAYER_COORDINATES player1 207.222992 -1309.637451 10.202317
SET_PLAYER_HEADING player1 60.0

DO_FADE 1500 FADE_IN
SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 987
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2_A ) 10000 1 // Mission brief

WHILE cs_time < 6800
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2_B ) 10000 1 // Mission brief

WHILE cs_time < 11088
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2_C ) 10000 1 // Mission brief

WHILE cs_time < 12888
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2_D ) 10000 1 // Mission brief

WHILE cs_time < 14496
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2_E ) 10000 1 // Mission brief

WHILE cs_time < 17164
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2_F ) 10000 1 // Mission brief

WHILE cs_time < 18793
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2_G ) 10000 1 // Mission brief

WHILE cs_time < 22223
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2_H ) 10000 1 // Mission brief

WHILE cs_time < 25376
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2_I ) 10000 1 // Mission brief

WHILE cs_time < 28768
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2_J ) 10000 1 // Mission brief

WHILE cs_time < 31266
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2_K ) 10000 1 // Mission brief

WHILE cs_time < 32433 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 33422
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE


DO_FADE 1500 FADE_OUT


CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE


SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_IN_FRONT_OF_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ03
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ04

LOAD_SPECIAL_CHARACTER 3 chef
LOAD_SPECIAL_CHARACTER 4 igbuddy
REQUEST_MODEL CELLPHONE
REQUEST_MODEL INFERNUS

SET_AREA_VISIBLE VIS_MAIN_MAP
LOAD_SCENE 117.1 -825.6 9.8

flag_player_on_lawyer_2 = 1

DELETE_OBJECT malibu_doors 
CREATE_OBJECT_NO_OFFSET od_clbdr_open 490.34 -77.017 11.598 malibu_doors
DONT_REMOVE_OBJECT malibu_doors
flag_malibu_doors_open = 1
flag_malibu_doors_closed = 0


WAIT 500

DO_FADE 1500 FADE_IN

// START OF MISSION
// Create Lance's car
CREATE_CAR infernus 213.575104 -1310.700928 10.346686 buddycar
SET_CAR_HEALTH buddycar 2000
LOCK_CAR_DOORS buddycar CARLOCK_UNLOCKED
SET_CAR_HEADING buddycar 156.0
CHANGE_CAR_COLOUR buddycar CARCOLOUR_WHITE CARCOLOUR_WHITE
ADD_BLIP_FOR_CAR buddycar buddycar_blip

// Create Lance
CREATE_CHAR_AS_PASSENGER buddycar PEDTYPE_CIVFEMALE SPECIAL04 0 buddy
SET_CHAR_HEADING buddy 143.0 
SET_CHAR_PERSONALITY buddy PEDSTAT_TOUGH_GUY
SET_CHAR_AS_PLAYER_FRIEND buddy Player1 TRUE
SET_CHAR_NEVER_TARGETTED buddy TRUE
SET_CHAR_SUFFERS_CRITICAL_HITS buddy FALSE
GIVE_WEAPON_TO_CHAR buddy WEAPONTYPE_PISTOL 9999
ADD_BLIP_FOR_CHAR buddy buddy_blip
SET_CHAR_CANT_BE_DRAGGED_OUT buddy TRUE
SET_CHAR_STAY_IN_CAR_WHEN_JACKED buddy TRUE

// Teleport Tommy into driver's seat of Lance's car and give 2*
WARP_PLAYER_INTO_CAR player1 buddycar
ALTER_WANTED_LEVEL player1 2

IF IS_CAR_DEAD buddycar
	GOTO mission_lawyer2_failed
ENDIF

IF IS_CHAR_DEAD	buddy
	PRINT_NOW ( COK2_26 ) 5000 2 //YOUR BUDDY IS DEAD!
	GOTO mission_lawyer2_failed
ENDIF

LOAD_MISSION_AUDIO 2 LAW2_5 // Lance's final voice line
ADD_BLIP_FOR_COORD 242.6 -1281.2 10.0 hotel_blip
PRINT_NOW ( LAW2_10 ) 15000 2  //Drive to the hotel

	IF IS_CHAR_DEAD	buddy
		PRINT_NOW ( COK2_26 ) 5000 2 //YOUR BUDDY IS DEAD!
		GOTO mission_lawyer2_failed
	ENDIF

	IF IS_CAR_DEAD buddycar
		GOTO mission_lawyer2_failed
	ENDIF

WHILE NOT IS_CAR_IN_AREA_3D buddycar 272.8 -1341.5 16.0 212.5 -1280.0 8.0 FALSE
OR NOT IS_CHAR_SITTING_IN_CAR buddy	buddycar
OR NOT IS_CHAR_SITTING_IN_CAR scplayer buddycar
	WAIT 0

	IF IS_CHAR_DEAD	buddy
		PRINT_NOW ( COK2_26 ) 5000 2 //YOUR BUDDY IS DEAD!
		GOTO mission_lawyer2_failed
	ENDIF

	IF IS_CAR_DEAD buddycar
		GOTO mission_lawyer2_failed
	ENDIF

	IF IS_CAR_IN_AREA_3D buddycar 272.9 -1220.6 16.0 212.5 -1280.0 8.0 FALSE
	AND IS_CHAR_SITTING_IN_CAR buddy buddycar
	AND IS_CHAR_SITTING_IN_CAR scplayer buddycar
		 GOTO warp_buddycar
	ENDIF

	IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 buddy 10.0 10.0 10.0 FALSE
		IF buddy_blip_active = 0
			REMOVE_BLIP buddy_blip
   			ADD_BLIP_FOR_CHAR buddy buddy_blip 
   			PRINT_NOW ( LAW2_13 ) 5000 2 //You've left lance  
			buddy_blip_active = 1
		ENDIF
   	ELSE
   		IF NOT IS_CAR_DEAD buddycar
			IF NOT IS_CHAR_IN_CAR buddy buddycar
				SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER buddy buddycar
			ENDIF
			IF IS_PLAYER_IN_CAR	player1 buddycar
				REMOVE_BLIP buddy_blip
			ENDIF
			buddy_blip_active = 0
		ENDIF
   	ENDIF

	IF NOT IS_PLAYER_IN_CAR	player1 buddycar
		IF NOT IS_CHAR_IN_CAR buddy buddycar 
			IF buddycar_blip_active = 0
				REMOVE_BLIP buddycar_blip
	   			ADD_BLIP_FOR_CAR buddycar buddycar_blip  
				buddycar_blip_active = 1
			ENDIF
		ENDIF
   	ELSE
		IF buddycar_blip_active = 1
			REMOVE_BLIP buddycar_blip
			buddycar_blip_active = 0
		ENDIF
   	ENDIF
ENDWHILE

warp_buddycar:
DO_FADE 500 FADE_OUT
WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON
IF NOT IS_CAR_DEAD buddycar
	GET_CAR_HEADING buddycar bud_Heading
ENDIF

IF IS_CAR_IN_AREA_3D buddycar 272.8 -1341.5 16.0 212.5 -1280.0 8.0 FALSE
	IF NOT IS_CAR_DEAD buddycar
		SET_CAR_CRUISE_SPEED buddycar 0.0 
		SET_CAR_DRIVING_STYLE buddycar DRIVINGMODE_PLOUGHTHROUGH
		CLEAR_AREA 232.1 -1323.4 10.9 40.0 TRUE
		SET_CAR_COORDINATES buddycar 236.7 -1308.2 -100.0
		SET_CAR_HEADING buddycar 347.3
		SET_CAR_CRUISE_SPEED buddycar 20.0
		CAR_GOTO_COORDINATES buddycar 242.35 -1279.9 10.9
		CLEAR_AREA 242.2 -1279.9 10.9 20.0 TRUE
		CLEAR_AREA 247.264 -1281.508 10.495 40.0 FALSE
		SET_FIXED_CAMERA_POSITION 239.295 -1283.295 10.713 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT 239.799 -1282.436 10.622 JUMP_CUT
		drove_in_from_south = 1
	ENDIF
ELSE
	IF NOT IS_CAR_DEAD buddycar
		SET_CAR_CRUISE_SPEED buddycar 0.0 
		SET_CAR_DRIVING_STYLE buddycar DRIVINGMODE_PLOUGHTHROUGH
		CLEAR_AREA 246.3 -1257.7 10.9 40.0 TRUE
		SET_CAR_COORDINATES buddycar 246.3 -1257.7 -100.0
		SET_CAR_HEADING buddycar 171.8
		SET_CAR_CRUISE_SPEED buddycar 20.0
		CAR_GOTO_COORDINATES buddycar 242.2 -1279.9 10.9
		CLEAR_AREA 242.2 -1279.9 10.9 20.0 TRUE
		CLEAR_AREA 247.264 -1281.508 10.495 40.0 FALSE
		SET_FIXED_CAMERA_POSITION 237.960 -1286.392 10.586 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT 238.473 -1285.534 10.609 JUMP_CUT
	ENDIF
ENDIF

DO_FADE 1000 FADE_IN
WAIT 3000

IF NOT IS_CAR_DEAD buddycar
	SET_CHAR_OBJ_LEAVE_CAR scplayer buddycar
ENDIF
WAIT 1300

IF NOT IS_CHAR_DEAD	buddy
	SET_CHAR_SHUFFLE_INTO_DRIVERS_SEAT buddy
ENDIF

IF drove_in_from_south = 0
	SET_FIXED_CAMERA_POSITION 237.787 -1282.583 12.615 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 238.638 -1282.366 12.135 JUMP_CUT
ELSE
	SET_FIXED_CAMERA_POSITION 239.975 -1273.806 12.873 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 240.511 -1274.468 12.350 JUMP_CUT
ENDIF

IF NOT IS_CHAR_DEAD	buddy
	PLAYER_LOOK_AT_CHAR_ALWAYS player1 buddy
	CHAR_LOOK_AT_CHAR_ALWAYS buddy scplayer
ENDIF

WAIT 1000

IF HAS_MISSION_AUDIO_LOADED	2
	PLAY_MISSION_AUDIO 2
ENDIF

PRINT_NOW ( LAW2_5 ) 4000 2	//I'll be in touch
WAIT 4000

IF NOT IS_CAR_DEAD buddycar
	CLEAR_AREA 200.2 -1460.3 10.9 40.0 FALSE
	CLEAR_AREA 242.2 -1279.9 10.9 40.0 FALSE
	CLEAR_AREA_OF_CARS 213.4 -1376.9 0.0 279.7 -1216.2 30.0
	IF drove_in_from_south = 0
		SET_FIXED_CAMERA_POSITION 245.135 -1276.517 11.710 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT 244.775 -1277.430 11.519 JUMP_CUT
	ELSE
		SET_FIXED_CAMERA_POSITION 242.804 -1271.559 10.617 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT 242.975 -1272.544 10.603 JUMP_CUT
	ENDIF
	CAR_GOTO_COORDINATES buddycar 200.2 -1460.3 10.9
	SET_CAR_CRUISE_SPEED buddycar 40.0
	SET_CAR_DRIVING_STYLE buddycar DRIVINGMODE_PLOUGHTHROUGH
	IF NOT IS_CHAR_DEAD buddy
		STOP_CHAR_LOOKING buddy
	ENDIF
ENDIF

TIMERB = 0
WHILE NOT LOCATE_CAR_3D buddycar 200.2 -1460.3 10.9 4.0 4.0 4.0 FALSE
	WAIT 0
	IF TIMERB > 4000
		GOTO delete_buddycar
	ENDIF
	IF IS_CHAR_DEAD	buddy
		PRINT_NOW ( COK2_26 ) 5000 2 //YOUR BUDDY IS DEAD!
		GOTO mission_lawyer2_failed
	ENDIF
	IF IS_CAR_DEAD buddycar
		GOTO mission_lawyer2_failed
	ENDIF
ENDWHILE

STOP_CHAR_LOOKING scplayer

delete_buddycar:
RESTORE_CAMERA_JUMPCUT
DELETE_CAR buddycar
GOTO mission_lawyer2_passed

 // Mission lawyer2 failed
mission_lawyer2_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

// mission lawyer2 passed
mission_lawyer2_passed:
//flag_lawyer_mission2_passed = 1
PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 200 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 200 
/*REGISTER_MISSION_PASSED	LAW_2
PLAYER_MADE_PROGRESS 1*/
RETURN

// mission cleanup
mission_cleanup_lawyer2:
flag_player_on_mission = 0
DELETE_OBJECT malibu_doors 
CREATE_OBJECT_NO_OFFSET od_clbdr_close 490.34 -77.017 11.598 malibu_doors
DONT_REMOVE_OBJECT malibu_doors
flag_malibu_doors_closed = 1
flag_malibu_doors_open = 0
flag_player_on_lawyer_2	= 0
flag_player_in_malibu = 0
GET_GAME_TIMER timer_mobile_start
MARK_MODEL_AS_NO_LONGER_NEEDED infernus
MARK_MODEL_AS_NO_LONGER_NEEDED cleaver
MARK_MODEL_AS_NO_LONGER_NEEDED colt45
MARK_MODEL_AS_NO_LONGER_NEEDED cellphone
MARK_MODEL_AS_NO_LONGER_NEEDED knifecur
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4
CLEAR_MISSION_AUDIO 1
CLEAR_MISSION_AUDIO 2
REMOVE_BLIP buddy_blip
REMOVE_BLIP hotel_blip
REMOVE_BLIP buddycar_blip
MISSION_HAS_FINISHED
RETURN
}