MISSION_START
SCRIPT_NAME PRAC

// Initializing vars
VAR_INT allow_movement_after_cleanup yesduping practice_spotlight gs_package htc_money phone bar_brawl_nades htc_vehicle

VAR_INT htc_cheetah htc_pcj pp86_maverick demoman_ip_rcheli bab_cs_infernus juice_end_pcj ga_admiral
VAR_INT snd_end_squalo bar_brawl_securicar ctc_sanchez candylimo

VAR_INT pp86_lance demoman_ip_phil juice_end_mercedes ga_diaz bar_brawl_dbp1 bar_brawl_dbp2 ctc_collector1 ctc_collector2

VAR_INT gs_cs_marker htc_jump_cheetah_marker htc_jump_pcj_marker pp86_marker demoman_ip_marker
VAR_INT bab_cs_marker juice_end_marker ga_marker snd_end_marker bar_brawl_marker ctc_marker taxi_ip_marker

//REMOVE_SPHERE practice_marker     // Remove the "mission marker"
flag_lawyer_mission2_passed = 0   // Set BAB passed var to 0 to disable phone calls
allow_movement_after_cleanup = 0
selecting = 1

GOSUB practice_begin

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOTO fail_mission
ENDIF

GOSUB mission_cleanup

TERMINATE_THIS_SCRIPT
MISSION_END

teleport_back:
    SET_PLAYER_COORDINATES player1 -1162.540771 -1303.468140 14.837565
    SET_PLAYER_HEADING player1 180.0
    RETURN

fail_mission:
allow_movement_after_cleanup = 1
PRINT_BIG M_FAIL 5000 1 // MISSION FAILED!
GOSUB mission_cleanup
/*IF NOT HAS_DEATHARREST_BEEN_EXECUTED
    SET_PLAYER_COORDINATES player1 -1162.540771 -1303.468140 14.837565
    SET_PLAYER_HEADING player1 180.0
ENDIF*/
TERMINATE_THIS_SCRIPT
RETURN


practice_begin:
flag_player_on_mission = 1
OVERRIDE_NEXT_RESTART -1162.540771 -1303.468140 14.837565 180.0
SET_AREA_VISIBLE VIS_MAIN_MAP // 04BB: select_interiour 0
SET_PLAYER_CONTROL player1 OFF

// Loading models
REQUEST_MODEL COLT45
REQUEST_MODEL UZI
REQUEST_MODEL RUGER
REQUEST_MODEL CHNSAW
REQUEST_MODEL CHROMEGUN
REQUEST_MODEL GRENADE
REQUEST_MODEL SNIPER
REQUEST_MODEL M60

REQUEST_MODEL CHEETAH
REQUEST_MODEL PCJ600
REQUEST_MODEL MAVERICK
REQUEST_MODEL RCGOBLIN
REQUEST_MODEL INFERNUS
REQUEST_MODEL ADMIRAL
REQUEST_MODEL SQUALO
REQUEST_MODEL VCNMAV
REQUEST_MODEL SECURICA
REQUEST_MODEL SANCHEZ

REQUEST_MODEL GDA
REQUEST_MODEL GDB

LOAD_SPECIAL_CHARACTER 1 IGBUDDY
LOAD_SPECIAL_CHARACTER 2 IGPHIL
LOAD_SPECIAL_CHARACTER 3 IGMERC
LOAD_SPECIAL_CHARACTER 4 IGDIAZ
LOAD_SPECIAL_CHARACTER 5 MBA
LOAD_SPECIAL_CHARACTER 6 MBB

LOAD_ALL_MODELS_NOW

// Giving player movement and providing weapons and money
    SET_PLAYER_CONTROL player1 ON
    GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_CHAINSAW 1
    GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_GRENADE 500
    GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_SHOTGUN 5
    GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_RUGER 500
    GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_SNIPERRIFLE 100
    GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_M60 100
    GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_UZI 500
    ADD_SCORE player1 1000000

// G-Spotlight cutscene package pickup
    CREATE_OBJECT_NO_OFFSET dts_spot_a -1176.219360 -1318.076660 14.800929 practice_spotlight   // Spawns spotlight
    ROTATE_OBJECT practice_spotlight 160.0 160.0 FALSE
    CREATE_PICKUP package1 6 -1176.168823 -1318.154785 16.2 gs_package  // A package
    ADD_SPHERE -1175.163086 -1315.794434 14.801214 2.0 gs_cs_marker

// HTC marker jump (JP No SSU etc.), both with Cheetah and PCJ
    CREATE_CAR CHEETAH -1170.131226 -1321.227173 14.837519 htc_cheetah
    CHANGE_CAR_COLOUR htc_cheetah 43 1 // Dark green
    SET_CAR_HEADING htc_cheetah 335.0
    SET_CAR_HEALTH htc_cheetah 10000

    CREATE_CAR PCJ600 -1171.7 -1318.6 14.822949 htc_pcj
    CHANGE_CAR_COLOUR htc_pcj 43 1 // Dark green
    SET_CAR_HEADING htc_pcj 335.0
    SET_CAR_HEALTH htc_pcj 10000

    ADD_SPHERE -1168.798706 -1318.395386 14.837980 0.8 htc_jump_cheetah_marker
    ADD_SPHERE -1171.019165 -1317.085205 14.824290 0.8 htc_jump_pcj_marker
    CREATE_PROTECTION_PICKUP -1171.570435 -1320.473999 14.828852 5000 5000 htc_money

// Phnom Penh '86 shooting
    CREATE_CAR MAVERICK -1162.5 -1322.368652 14.867218 pp86_maverick
    CHANGE_CAR_COLOUR pp86_maverick 3 1
    SET_CAR_HEADING pp86_maverick 370.0
    SET_CAR_HEALTH pp86_maverick 10000
    CAR_SET_IDLE pp86_maverick

    CREATE_CHAR_INSIDE_CAR pp86_maverick PEDTYPE_CIVFEMALE SPECIAL01 pp86_lance 
    SET_CHAR_HEALTH pp86_lance 10000

    ADD_SPHERE -1163.470215 -1317.255859 14.861924 2.0 pp86_marker

// Demolition Man instapass setup
    CREATE_CAR RCGOBLIN -1157.456421 -1314.955566 14.887068 demoman_ip_rcheli
    SET_CAR_HEADING demoman_ip_rcheli 60.0
    SET_CAR_HEALTH demoman_ip_rcheli 10000

    CREATE_CHAR PEDTYPE_CIVMALE SPECIAL02 -1157.456421 -1314.955566 15.887068 demoman_ip_phil
    SET_CHAR_HEADING demoman_ip_phil 60.0
    SET_CHAR_HEALTH demoman_ip_phil 10000
    SET_CHAR_STAY_IN_SAME_PLACE demoman_ip_phil TRUE

    ADD_SPHERE -1158.750488 -1314.221680 14.879073 2.0 demoman_ip_marker

// Back Alley Brawl ending cutscene movement
    CREATE_CAR INFERNUS -1181.909668 -1317.192871 14.849720 bab_cs_infernus
    CHANGE_CAR_COLOUR bab_cs_infernus 1 1 // White
    SET_CAR_HEADING bab_cs_infernus 335.0
    SET_CAR_HEALTH bab_cs_infernus 10000

    CREATE_PICKUP CELLPHONE PICKUP_ON_STREET -1181.909668 -1318.192871 15.849720 phone

    ADD_SPHERE -1179.881470 -1313.508911 14.773191 2.0 bab_cs_marker

GOSUB juice_end_objects
GOTO remaining_objects

// Love Juice - falling off of PCJ with Mercedes into end marker
// Treating it as a separate block of code so it can be reused since the PCJ and mercedes go with you when practicing this.
juice_end_objects:    
    CREATE_CAR PCJ600 -1156.819458 -1310.744873 14.881389 juice_end_pcj
    SET_CAR_HEADING juice_end_pcj 60.0
    SET_CAR_HEALTH juice_end_pcj 10000

    CREATE_CHAR_AS_PASSENGER juice_end_pcj PEDTYPE_CIVFEMALE SPECIAL03 0 juice_end_mercedes
    //SET_CHAR_HEALTH juice_end_mercedes 66000
    //SET_CHAR_SUFFERS_CRITICAL_HITS juice_end_mercedes FALSE
    SET_CHAR_STAY_IN_CAR_WHEN_JACKED juice_end_mercedes TRUE

    ADD_SPHERE -1156.819458 -1310.744873 14.881389 3.0 juice_end_marker
    RETURN

// Guardian Angels (starting from the deal)
remaining_objects:
    CREATE_CAR ADMIRAL -1152.769165 -1307.570313 13.7 ga_admiral
    CHANGE_CAR_COLOUR ga_admiral 8 8 // Diaz's car colors
    SET_CAR_HEADING ga_admiral 65.0
    SET_CAR_HEALTH ga_admiral 10000
    CAR_SET_IDLE ga_admiral
    FREEZE_CAR_POSITION ga_admiral TRUE

    CREATE_CHAR_INSIDE_CAR ga_admiral PEDTYPE_GANG_DIAZ SPECIAL04 ga_diaz
    SET_CHAR_HEALTH ga_diaz 10000
    
    ADD_SPHERE -1155.757202 -1306.177368 14.877080 2.0 ga_marker

// Supply and Demand ending cutscene movement
    CREATE_CAR SQUALO -1188.031738 -1314.430542 14.836496 snd_end_squalo
    SET_CAR_HEADING snd_end_squalo 65.0
    SET_CAR_HEALTH snd_end_squalo 10000

    ADD_SPHERE -1187.209839 -1310.769775 14.764548 2.0 snd_end_marker

// Bar Brawl nade throw(s)
    CREATE_CAR SECURICA -1150.553223 -1302.060547 14.894367 bar_brawl_securicar
    SET_CAR_HEADING bar_brawl_securicar 65.0
    SET_CAR_HEALTH bar_brawl_securicar 10000

    CREATE_CHAR PEDTYPE_CIVMALE GDA -1150.624146 -1301.266968 17.376385 bar_brawl_dbp1
    CREATE_CHAR PEDTYPE_CIVMALE GDB -1151.220703 -1302.389648 17.375740 bar_brawl_dbp2
    SET_CHAR_HEADING bar_brawl_dbp1 90.0
    SET_CHAR_HEADING bar_brawl_dbp2 90.0
    SET_CHAR_HEALTH bar_brawl_dbp1 10000
    SET_CHAR_HEALTH bar_brawl_dbp2 10000
    SET_CHAR_STAY_IN_SAME_PLACE bar_brawl_dbp1 TRUE
    SET_CHAR_STAY_IN_SAME_PLACE bar_brawl_dbp2 TRUE

    CREATE_PICKUP GRENADE PICKUP_ON_STREET -1152.803101 -1300.984375 16.584904 bar_brawl_nades

    ADD_SPHERE -1154.562988 -1300.136108 14.870331 2.0 bar_brawl_marker

// Cap the Collector (with HP displays)
    CREATE_CAR SANCHEZ -1150.911621 -1297.551270 14.883100 ctc_sanchez
    SET_CAR_HEADING ctc_sanchez 65.0
    SET_CAR_HEALTH ctc_sanchez 10000

    CREATE_CHAR_INSIDE_CAR ctc_sanchez PEDTYPE_CIVMALE SPECIAL05 ctc_collector1
    CREATE_CHAR_AS_PASSENGER ctc_sanchez PEDTYPE_CIVMALE SPECIAL06 0 ctc_collector2
    SET_CHAR_HEALTH ctc_collector1 10000
    SET_CHAR_HEALTH ctc_collector2 10000
    CAR_SET_IDLE ctc_sanchez

    ADD_SPHERE -1152.782349 -1296.682373 14.871946 2.0 ctc_marker

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////// Wait loop for player's decision for practice, and the actual triggers for the spheres/markers /////////////
//wait_loop:
WHILE LOCATE_PLAYER_ANY_MEANS_2D player1 -1161.0 -1315.375 41.0 22.375 FALSE

    WAIT 0

    // G-Spotlight mission fragment
    IF LOCATE_PLAYER_ON_FOOT_3D player1 -1175.163086 -1315.794434 14.801214 1.5 1.5 1.5 FALSE
        GOSUB gs_cs
        //GOTO wait_loop
    ENDIF

    // Hit the Courier jump
    // Cheetah
    IF LOCATE_PLAYER_ON_FOOT_3D player1 -1168.798706 -1318.395386 14.837980 0.5 0.5 0.5 FALSE
        htc_vehicle = 1
        GOTO mission_cleanup
    ENDIF
    // PCJ
    IF LOCATE_PLAYER_ON_FOOT_3D player1 -1171.019165 -1317.085205 14.824290 0.5 0.5 0.5 FALSE
        htc_vehicle = 2
        GOTO mission_cleanup
    ENDIF

    // Phnom Penh '86
    IF LOCATE_PLAYER_ON_FOOT_3D player1 -1163.470215 -1317.255859 14.861924 1.5 1.5 1.5 FALSE
        GOTO mission_cleanup
    ENDIF

    // The Shootist / Demolition Man instapass
    IF LOCATE_PLAYER_ON_FOOT_3D player1 -1158.750488 -1314.221680 14.879073 1.5 1.5 1.5 FALSE
        OVERRIDE_NEXT_RESTART 253.4462 -229.9782 10.90157 270.0
        GOTO mission_cleanup
    ENDIF

    // Back Alley Brawl 
    IF LOCATE_PLAYER_ON_FOOT_3D player1 -1179.881470 -1313.508911 14.773191 1.5 1.5 1.5 FALSE
        GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_PISTOL 30
        SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_PISTOL
        GOTO mission_cleanup
    ENDIF

    // Love Juice mission fragment
    IF LOCATE_STOPPED_PLAYER_IN_CAR_3D player1 -1156.819458 -1310.744873 14.881389 1.5 1.5 1.5 FALSE
        IF IS_PLAYER_IN_MODEL player1 PCJ600
            IF IS_CHAR_IN_CAR juice_end_mercedes juice_end_pcj
                GOSUB juice_end
                SET_PLAYER_HEADING player1 180.0
            ENDIF
        ENDIF
    ENDIF

    // Guardian Angels
    IF LOCATE_PLAYER_ON_FOOT_3D player1 -1155.757202 -1306.177368 14.877080 1.5 1.5 1.5 FALSE
        GOTO mission_cleanup
    ENDIF

    // Supply and Demand "mission fragment"
    IF LOCATE_PLAYER_ON_FOOT_3D player1 -1187.209839 -1310.769775 14.764548 1.5 1.5 1.5 FALSE
        SET_PLAYER_CONTROL player1 OFF
        WAIT 1000
        GOSUB snd_end
    ENDIF

    // Bar Brawl
    IF LOCATE_PLAYER_ON_FOOT_3D player1 -1154.562988 -1300.136108 14.870331 1.5 1.5 1.5 FALSE
        view_of_ocean_view = 0 // This makes it possible to keep seeing the hotel cs even if you do the mission multiple times
        GOTO mission_cleanup
    ENDIF

    // CTC
    IF LOCATE_PLAYER_ON_FOOT_3D player1 -1152.782349 -1296.682373 14.871946 1.5 1.5 1.5 FALSE
        //allow_movement_after_cleanup = 1
        GOTO mission_cleanup
    ENDIF

ENDWHILE
// Fail if exit the area
selecting = 0
allow_movement_after_cleanup = 1
//GOTO mission_cleanup
//GOTO wait_loop

mission_cleanup:
    REMOVE_SPHERE gs_cs_marker
    REMOVE_SPHERE htc_jump_cheetah_marker
    REMOVE_SPHERE htc_jump_pcj_marker
    REMOVE_SPHERE pp86_marker
    REMOVE_SPHERE demoman_ip_marker
    REMOVE_SPHERE bab_cs_marker
    REMOVE_SPHERE juice_end_marker
    REMOVE_SPHERE ga_marker
    REMOVE_SPHERE snd_end_marker
    REMOVE_SPHERE bar_brawl_marker
    REMOVE_SPHERE ctc_marker

    REMOVE_PICKUP phone
    REMOVE_PICKUP htc_money

    MARK_MODEL_AS_NO_LONGER_NEEDED COLT45
    MARK_MODEL_AS_NO_LONGER_NEEDED UZI
    MARK_MODEL_AS_NO_LONGER_NEEDED RUGER
    MARK_MODEL_AS_NO_LONGER_NEEDED CHNSAW
    MARK_MODEL_AS_NO_LONGER_NEEDED CHROMEGUN
    MARK_MODEL_AS_NO_LONGER_NEEDED GRENADE
    MARK_MODEL_AS_NO_LONGER_NEEDED SNIPER

    MARK_MODEL_AS_NO_LONGER_NEEDED CHEETAH
    MARK_MODEL_AS_NO_LONGER_NEEDED PCJ600
    MARK_MODEL_AS_NO_LONGER_NEEDED MAVERICK  
    MARK_MODEL_AS_NO_LONGER_NEEDED RCGOBLIN
    MARK_MODEL_AS_NO_LONGER_NEEDED INFERNUS
    MARK_MODEL_AS_NO_LONGER_NEEDED ADMIRAL
    MARK_MODEL_AS_NO_LONGER_NEEDED SQUALO
    MARK_MODEL_AS_NO_LONGER_NEEDED VCNMAV
    MARK_MODEL_AS_NO_LONGER_NEEDED SECURICA
    MARK_MODEL_AS_NO_LONGER_NEEDED SANCHEZ
    MARK_MODEL_AS_NO_LONGER_NEEDED STRETCH
    MARK_MODEL_AS_NO_LONGER_NEEDED GDA
    MARK_MODEL_AS_NO_LONGER_NEEDED GDB

    UNLOAD_SPECIAL_CHARACTER 1
    UNLOAD_SPECIAL_CHARACTER 2
    UNLOAD_SPECIAL_CHARACTER 3
    UNLOAD_SPECIAL_CHARACTER 4
    UNLOAD_SPECIAL_CHARACTER 5
    UNLOAD_SPECIAL_CHARACTER 6

    REMOVE_CHAR_ELEGANTLY pp86_lance
    REMOVE_CHAR_ELEGANTLY demoman_ip_phil
    REMOVE_CHAR_ELEGANTLY juice_end_mercedes
    REMOVE_CHAR_ELEGANTLY ga_diaz
    REMOVE_CHAR_ELEGANTLY bar_brawl_dbp1
    REMOVE_CHAR_ELEGANTLY bar_brawl_dbp2
    REMOVE_CHAR_ELEGANTLY ctc_collector1
    REMOVE_CHAR_ELEGANTLY ctc_collector2

    DELETE_CAR bab_cs_infernus
    DELETE_CAR snd_end_squalo
    DELETE_CAR demoman_ip_rcheli
    DELETE_CAR ga_admiral  
    DELETE_CAR ctc_sanchez
    //DELETE_CAR htc_cheetah
    //DELETE_CAR htc_pcj
    DELETE_CAR bar_brawl_securicar
    //DELETE_CAR pp86_maverick
    DELETE_CAR ga_admiral
    DELETE_CAR juice_end_pcj
    
    REMOVE_PICKUP bar_brawl_nades
    REMOVE_PICKUP gs_package
    

    MISSION_HAS_FINISHED

    SET_PLAYER_CONTROL player1 OFF
    IF allow_movement_after_cleanup = 1
        SET_PLAYER_CONTROL player1 ON
    ENDIF

    flag_player_on_mission = 0
    selecting = 0
    RETURN

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*********************************************************************************************************************/
/****************************** Mission Fragments (should probably separate at some point) ***************************/
/*********************************************************************************************************************/
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
gs_cs:
    CREATE_COLLECTABLE1 -16.1 991.7 10.9 // The relevant package 
    LOAD_MISSION_TEXT PORN4
    SWITCH_WIDESCREEN ON
    SET_PLAYER_COORDINATES player1 -2.8 985.9 10.9
    SET_PLAYER_CONTROL player1 OFF
    WAIT 1000

    SWITCH_WIDESCREEN OFF
    DO_FADE 500 FADE_OUT
    WHILE GET_FADING_STATUS
        WAIT 0
    ENDWHILE
    SET_PLAYER_COORDINATES player1 -2.8 985.9 10.9
    SET_PLAYER_HEADING player1 260.5

    LOAD_SCENE 17.6 957.6 16.7 
    SET_PLAYER_CONTROL player1 ON
    SET_FIXED_CAMERA_POSITION 39.5 940.1 21.8 0.0 0.0 0.0
    POINT_CAMERA_AT_POINT 17.6 957.6 16.7 JUMP_CUT
    DO_FADE 500 FADE_IN
    WHILE GET_FADING_STATUS
        WAIT 0
    ENDWHILE

    PLAY_MISSION_PASSED_TUNE 1
    PRINT_BIG POR_AS1 5000 6 // FILM STUDIO ASSET COMPLETED
    WAIT 5000

    LOAD_SCENE -4.0 961.5 9.7
    SET_FIXED_CAMERA_POSITION 9.2 964.6 12.9 0.0 0.0 0.0
    POINT_CAMERA_AT_POINT -4.0 961.5 9.7 JUMP_CUT
    PRINT_WITH_NUMBER_NOW POR_AS2 porn_revenue 6000 1//Inter Global Films will now generate revenue up to a maximum of $~1~. Make sure you collect it regularly.
    WAIT 6000

    DO_FADE 500 FADE_OUT
    WHILE GET_FADING_STATUS
        WAIT 0
    ENDWHILE

    SET_PLAYER_COORDINATES player1 -1164.690063 -1308.872559 14.5
    SET_PLAYER_HEADING player1 150.0
    GET_PLAYER_COORDINATES player1 player_x player_y player_z
    LOAD_SCENE player_x player_y player_z

    DO_FADE 500 FADE_IN
            
    RESTORE_CAMERA_JUMPCUT
    SET_PLAYER_CONTROL player1 ON
    SWITCH_WIDESCREEN OFF
    RETURN

juice_end:
    REMOVE_SPHERE juice_end_marker

    VAR_INT radar_blip_studio_rock1 radar_blip_merc_rock1 flag_merc_dead_rock1 flag_merc_in_group_rock1 cutcar2_rock1
    VAR_INT juice_timer gametime_old gametime_new gametime_diff
    SET_PLAYER_COORDINATES player1 -492.648315 1105.887817 10.428333
    SET_CAR_HEADING juice_end_pcj 70.0
    WAIT 1000

    selecting = 0
    LOAD_MISSION_TEXT ROCK1
    flag_merc_in_group_rock1 = 1
    SET_PLAYER_AS_LEADER juice_end_mercedes player1
    SET_CHAR_RUNNING juice_end_mercedes ON
    SET_CHAR_CANT_BE_DRAGGED_OUT juice_end_mercedes TRUE
    RESTORE_CAMERA_JUMPCUT

    //SET_PLAYER_CONTROL player1 ON
    SET_POLICE_IGNORE_PLAYER player1 ON
    SET_EVERYONE_IGNORE_PLAYER player1 ON

    PRINT_NOW RBM1_13 7000 1 // Get the 'Love Juice' and Mercedes to the band before they are needed on stage.
    ADD_BLIP_FOR_COORD -867.8 1165.7 10.2 radar_blip_studio_rock1
    blob_flag = 1

    WHILE NOT LOCATE_STOPPED_CHAR_ANY_MEANS_3D juice_end_mercedes -867.8 1165.7 10.2 4.0 4.0 4.0 blob_flag 
        WAIT 0
        IF IS_CHAR_DEAD juice_end_mercedes
            PRINT_NOW RBM1_8 5000 1 //"You idiot Mercedes is dead!"
            EXPLODE_PLAYER_HEAD player1
            RETURN
        ELSE
            IF flag_merc_in_group_rock1 = 1 
                IF NOT IS_CHAR_IN_PLAYERS_GROUP juice_end_mercedes player1
                    REMOVE_BLIP radar_blip_studio_rock1
                    ADD_BLIP_FOR_CHAR juice_end_mercedes radar_blip_merc_rock1
                    PRINT_NOW HEY 5000 1 // "Don't leave her behind!"
                    blob_flag = 0
                    flag_merc_in_group_rock1 = 0
                ENDIF					
            ENDIF
            IF flag_merc_in_group_rock1 = 0
                IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 juice_end_mercedes 8.0 8.0 FALSE
                    REMOVE_BLIP radar_blip_merc_rock1
                    PRINT_NOW RBM1_13 7000 1 // "Get the love juice before the band are needed on stage"
                    SET_PLAYER_AS_LEADER juice_end_mercedes player1
                    ADD_BLIP_FOR_COORD -867.8 1165.7 10.2 radar_blip_studio_rock1
                    blob_flag = 1
                    flag_merc_in_group_rock1 = 1
                ENDIF
            ENDIF
        ENDIF
    ENDWHILE

    REMOVE_BLIP radar_blip_studio_rock1
    SWITCH_WIDESCREEN ON
    SET_PLAYER_CONTROL player1 OFF
    SET_EVERYONE_IGNORE_PLAYER player1 ON
    SET_POLICE_IGNORE_PLAYER player1 ON

    IF IS_CHAR_DEAD juice_end_mercedes
        PRINT_NOW RBM1_8 5000 1 //"You idiot Mercedes is dead!"
        EXPLODE_PLAYER_HEAD player1
    ELSE
        LEAVE_GROUP juice_end_mercedes
        SET_ANIM_GROUP_FOR_CHAR juice_end_mercedes ANIM_SEXY_WOMANPED
    ENDIF

    SET_FIXED_CAMERA_POSITION -874.13 1153.04 14.37 0.0 0.0 0.0
    POINT_CAMERA_AT_POINT -873.68 1153.89 14.10 JUMP_CUT

    LOAD_MISSION_AUDIO 1 MERC_39
    WHILE NOT HAS_MISSION_AUDIO_LOADED 1
        WAIT 0
        IF IS_CHAR_DEAD juice_end_mercedes
            PRINT_NOW RBM1_8 5000 1 //"You idiot Mercedes is dead!"
            EXPLODE_PLAYER_HEAD player1
        ENDIF
    ENDWHILE

    IF NOT IS_CHAR_DEAD juice_end_mercedes
        IF NOT IS_CHAR_IN_ANY_CAR juice_end_mercedes
            TURN_CHAR_TO_FACE_PLAYER juice_end_mercedes player1
        ENDIF
    ELSE
        PRINT_NOW RBM1_8 5000 1 //"You idiot Mercedes is dead!"
        EXPLODE_PLAYER_HEAD player1
    ENDIF

    PLAY_MISSION_AUDIO 1
    PRINT_NOW MERC_39 5000 1 //"I'll see you later, big boy."

    WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
        WAIT 0
        IF IS_CHAR_DEAD juice_end_mercedes
            PRINT_NOW RBM1_8 5000 1 //"You idiot Mercedes is dead!"
            EXPLODE_PLAYER_HEAD player1
        ENDIF
    ENDWHILE

    CLEAR_THIS_PRINT MERC_39

    IF IS_CHAR_IN_ANY_CAR juice_end_mercedes
        STORE_CAR_CHAR_IS_IN juice_end_mercedes cutcar2_rock1
        SET_CHAR_OBJ_LEAVE_CAR juice_end_mercedes cutcar2_rock1
        WHILE IS_CHAR_IN_ANY_CAR juice_end_mercedes
            WAIT 0
            IF IS_CHAR_DEAD juice_end_mercedes
                PRINT_NOW RBM1_8 5000 1 //"You idiot Mercedes is dead!"
                EXPLODE_PLAYER_HEAD player1
            ENDIF
            IF IS_CAR_DEAD cutcar2_rock1
                IF IS_CHAR_DEAD juice_end_mercedes
                    PRINT_NOW RBM1_8 5000 1 //"You idiot Mercedes is dead!"
                    EXPLODE_PLAYER_HEAD player1
                ENDIF
            ENDIF   
        ENDWHILE
    ENDIF

    SET_CHAR_OBJ_GOTO_COORD_ON_FOOT juice_end_mercedes -873.33 1161.28
    juice_timer = 0
    GET_GAME_TIMER gametime_old

    WHILE juice_timer < 3000
        WAIT 0	
        IF IS_CHAR_DEAD juice_end_mercedes
            PRINT_NOW RBM1_8 5000 1 //"You idiot Mercedes is dead!"
            EXPLODE_PLAYER_HEAD player1
        ENDIF

        GET_GAME_TIMER gametime_new
        gametime_diff = gametime_new - gametime_old
        gametime_old = gametime_new
        juice_timer += gametime_diff
    ENDWHILE

    CLEAR_AREA -872.90 1153.53 11.72 1.0 FALSE 
    SET_FIXED_CAMERA_POSITION -872.90 1153.53 11.72 0.0 0.0 0.0
    POINT_CAMERA_AT_POINT -873.31 1154.47 11.48 JUMP_CUT

    IF NOT IS_CHAR_DEAD juice_end_mercedes
        CHAR_SET_IDLE juice_end_mercedes
        SET_CHAR_COORDINATES juice_end_mercedes -872.40 1159.86 10.09
        SET_CHAR_OBJ_NO_OBJ juice_end_mercedes
    ELSE
        PRINT_NOW RBM1_8 5000 1 //"You idiot Mercedes is dead!"
        EXPLODE_PLAYER_HEAD player1
    ENDIF     

    SET_CHAR_OBJ_GOTO_COORD_ON_FOOT juice_end_mercedes -883.26 1159.30
    juice_timer = 0
    GET_GAME_TIMER gametime_old

    WHILE juice_timer < 2500
        WAIT 0
        IF IS_CHAR_DEAD juice_end_mercedes
            PRINT_NOW RBM1_8 5000 1 //"You idiot Mercedes is dead!"
            EXPLODE_PLAYER_HEAD player1
        ENDIF

        GET_GAME_TIMER gametime_new
        gametime_diff = gametime_new - gametime_old
        gametime_old = gametime_new
        juice_timer += gametime_diff
    ENDWHILE  	 

    SWITCH_WIDESCREEN OFF
    SET_PLAYER_CONTROL player1 ON
    SET_EVERYONE_IGNORE_PLAYER player1 OFF
    SET_POLICE_IGNORE_PLAYER player1 OFF
    RESTORE_CAMERA_JUMPCUT
    DELETE_CHAR juice_end_mercedes 
    WARP_CHAR_FROM_CAR_TO_COORD scplayer -1162.540771 -1303.468140 14.837565
    DELETE_CAR juice_end_pcj

    GOSUB juice_end_objects
    RETURN

snd_end:
    VAR_INT cameramode snd_end_vcnmav
    cameramode = 1

    SET_PLAYER_COORDINATES player1 -372.7 -656.7 6.9
    SET_PLAYER_HEADING player1 128.0
    SET_FIXED_CAMERA_POSITION -367.062 -660.511 10.406 0.0 0.0 0.0
    POINT_CAMERA_AT_POINT -368.0 -660.319 10.116 JUMP_CUT
    WAIT 1000

    SET_PLAYER_COORDINATES player1 -372.7 -656.7 6.9
    SWITCH_WIDESCREEN ON
    SET_PLAYER_CONTROL player1 ON

    CREATE_CAR VCNMAV -378.391296 -643.316284 10.413091 snd_end_vcnmav 
    SET_CAR_HEADING snd_end_vcnmav 180.0
    
    WHILE NOT IS_BUTTON_PRESSED 0 19 // "R3" or look behind on foot, submission in vehicle
        WAIT 0
        IF IS_BUTTON_PRESSED 0 18 // "L3" or crouch on foot, horn in vehicle
            SWITCH cameramode
            CASE 0
                WAIT 100
                SET_FIXED_CAMERA_POSITION -367.062 -660.511 10.406 0.0 0.0 0.0
                POINT_CAMERA_AT_POINT -368.0 -660.319 10.116 JUMP_CUT
                SWITCH_WIDESCREEN ON
                cameramode = 1
                BREAK
            CASE 1
                WAIT 100
                RESTORE_CAMERA_JUMPCUT
                SWITCH_WIDESCREEN OFF
                cameramode = 0
                BREAK
            ENDSWITCH
        ENDIF
    ENDWHILE

    SWITCH_WIDESCREEN OFF
    RESTORE_CAMERA_JUMPCUT
    WARP_CHAR_FROM_CAR_TO_COORD scplayer -1164.690063 -1308.872559 14.5
    WAIT 100
    DELETE_CAR snd_end_vcnmav
    RETURN