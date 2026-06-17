MISSION_START
SCRIPT_NAME PRAC2

// Initializing vars
VAR_INT fouriron_comet fouriron_marker ahod_car ahod_dude ahod_marker the_party_taxi_ip_cab the_party_taxi_ip_marker the_party_taxi_ip_mercedes tc_inject tc_dude tc_dude2 tc_marker

allow_movement_after_cleanup = 0
selecting = 1

// Resetting vars that get altered through various practice items
flag_lawyer_mission2_passed = 0     // Disable phone
flag_mob_52 = 0                     // Leo call not taken
flag_protect_mission1_passed = 0    // Bar Brawl not passed
flag_assin_mission3_passed = 0      // Autocide not passed
flag_mob_97 = 0                     // Autocide call not taken
flag_mob_96 = 0                     // COATCI call not taken
flag_baron_mission1_passed = 0      // The Chase passed

GOSUB practice_begin2

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOTO fail_mission2
ENDIF

GOSUB mission_cleanup2

TERMINATE_THIS_SCRIPT
MISSION_END

teleport_back2:
    SET_PLAYER_COORDINATES player1 -1155.529053 -1275.438477 14.813583
    SET_PLAYER_HEADING player1 180.0
    RETURN

fail_mission2:
allow_movement_after_cleanup = 1
PRINT_BIG M_FAIL 5000 1 // MISSION FAILED!
GOSUB mission_cleanup2
/*IF NOT HAS_DEATHARREST_BEEN_EXECUTED
    SET_PLAYER_COORDINATES player1 -1162.540771 -1303.468140 14.837565
    SET_PLAYER_HEADING player1 180.0
ENDIF*/
TERMINATE_THIS_SCRIPT
RETURN


practice_begin2:
flag_player_on_mission = 1
OVERRIDE_NEXT_RESTART -1155.529053 -1275.438477 14.813583 180.0
SET_AREA_VISIBLE VIS_MAIN_MAP // 04BB: select_interiour 0
SET_PLAYER_CONTROL player1 OFF

// Loading models
REQUEST_MODEL COMET
REQUEST_MODEL WASHING
REQUEST_MODEL KAUFMAN
REQUEST_MODEL BFINJECT

REQUEST_MODEL HMOST
REQUEST_MODEL SPECIAL03
REQUEST_MODEL SGa

REQUEST_MODEL M4

LOAD_SPECIAL_CHARACTER 1 SGC

LOAD_ALL_MODELS_NOW

// Giving player movement and providing weapons and money
    SET_PLAYER_CONTROL player1 ON

// Four Iron snipe
    CREATE_CAR COMET -1144.984619 -1291.015991 14.898906 fouriron_comet
    CHANGE_CAR_COLOUR fouriron_comet 19 1 // Bright pink
    SET_CAR_HEADING fouriron_comet 90.0
    SET_CAR_HEALTH fouriron_comet 10000
    ADD_SPHERE -1148.422974 -1290.974487 14.881677 2.0 fouriron_marker

// AHoD death strat
    CREATE_CAR WASHING -1143.283325 -1287.255493 -100.0 ahod_car
	CHANGE_CAR_COLOUR ahod_car 0 0
    SET_CAR_HEADING ahod_car 90.0
    SET_CAR_HEALTH ahod_car 10000
    FREEZE_CAR_POSITION ahod_car TRUE
    CREATE_CHAR_INSIDE_CAR ahod_car PEDTYPE_GANG_STREET HMOST ahod_dude
    ADD_SPHERE -1146.976807 -1287.038574 14.880610 2.0 ahod_marker

// The Party Taxi IP
    CREATE_CAR KAUFMAN -1142.901489 -1283.129639 -100.0 the_party_taxi_ip_cab
    SET_CAR_HEADING the_party_taxi_ip_cab 90.0
    SET_CAR_HEALTH the_party_taxi_ip_cab 10000
    FREEZE_CAR_POSITION the_party_taxi_ip_cab TRUE
    CREATE_CHAR_INSIDE_CAR the_party_taxi_ip_cab PEDTYPE_CIVFEMALE SPECIAL03 the_party_taxi_ip_mercedes
    ADD_SPHERE -1146.712646 -1283.178223 14.873811 2.0 the_party_taxi_ip_marker

// The Chase finish
    CREATE_CAR BFINJECT -1141.469116 -1278.931396 -100.0 tc_inject
    SET_CAR_HEADING tc_inject 90.0
    SET_CAR_HEALTH tc_inject 10000
    FREEZE_CAR_POSITION tc_inject TRUE
    // CREATE_CHAR_INSIDE_CAR tc_inject PEDTYPE_CIVMALE SGa tc_dude
    CREATE_CHAR_AS_PASSENGER tc_inject PEDTYPE_CIVMALE SGa 0 tc_dude2
    SET_CHAR_STAY_IN_CAR_WHEN_JACKED tc_dude2 TRUE
    ADD_SPHERE -1145.234131 -1279.079590 14.872563 2.0 tc_marker

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////// Wait loop for player's decision for practice, and the actual triggers for the spheres/markers /////////////
WHILE LOCATE_PLAYER_ANY_MEANS_2D player1 -1147.4 -1271.25 27.0 21.75 FALSE
    WAIT 0

// Four Iron snipe
    IF LOCATE_PLAYER_ON_FOOT_3D player1 -1148.422974 -1290.974487 14.881677 1.5 1.5 1.5 FALSE
        GOTO mission_cleanup2
    ENDIF

// AHoD death strat
    IF LOCATE_PLAYER_ON_FOOT_3D player1 -1146.976807 -1287.038574 14.880610 1.5 1.5 1.5 FALSE
        GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_M4 1
        GOTO mission_cleanup2
    ENDIF
// The Party Taxi IP
    IF LOCATE_PLAYER_ON_FOOT_3D player1 -1146.712646 -1283.178223 14.873811 1.5 1.5 1.5 FALSE
        GOTO mission_cleanup2
    ENDIF

// The Chase steal practice
    IF LOCATE_PLAYER_ON_FOOT_3D player1 -1145.234131 -1279.079590 14.872563 1.5 1.5 1.5 FALSE
        GOTO mission_cleanup2
    ENDIF

// The Chase finish cutscene drive practice
    IF IS_PLAYER_IN_CAR player1 tc_inject
        GOSUB tc_finish
    ENDIF

ENDWHILE

// Fail if exit the area
selecting = 0
allow_movement_after_cleanup = 1

mission_cleanup2:
    REMOVE_SPHERE fouriron_marker
    REMOVE_SPHERE ahod_marker
    REMOVE_SPHERE the_party_taxi_ip_marker
    REMOVE_SPHERE tc_marker

    MARK_MODEL_AS_NO_LONGER_NEEDED COMET
    MARK_MODEL_AS_NO_LONGER_NEEDED WASHING
    MARK_MODEL_AS_NO_LONGER_NEEDED HMOST
    MARK_MODEL_AS_NO_LONGER_NEEDED SPECIAL03
    MARK_MODEL_AS_NO_LONGER_NEEDED M4
    MARK_MODEL_AS_NO_LONGER_NEEDED SGa
    MARK_MODEL_AS_NO_LONGER_NEEDED BFINJECT

    DELETE_CAR fouriron_comet
    DELETE_CAR ahod_car
    DELETE_CAR the_party_taxi_ip_cab
    DELETE_CAR tc_inject

    MISSION_HAS_FINISHED

    SET_PLAYER_CONTROL player1 OFF
    IF allow_movement_after_cleanup = 1
        SET_PLAYER_CONTROL player1 ON
    ENDIF

    flag_player_on_mission = 0
    selecting = 0
    RETURN

// The Chase mission fragment
tc_finish:
    VAR_INT traitor_sub traitors_car_sub temp_roadblock radar_blip_traitors_car flag_baron1_on_foot
    flag_baron1_on_foot = 0

    WARP_PLAYER_FROM_CAR_TO_COORD player1 116.306862 1001.447388 13.5
    RESTORE_CAMERA_JUMPCUT
    SET_CAMERA_BEHIND_PLAYER
    
    // Practice SCM setup stuff
    CREATE_OBJECT_NO_OFFSET nt_roadblockCI -97.3 1061.8 11.6 temp_roadblock // temporary roadblock for driving practice
    WAIT 0
    CREATE_CAR BFINJECT 116.306862 1001.447388 13.2 traitors_car_sub
    SET_CAR_HEAVY traitors_car_sub TRUE
    SET_CAR_STRONG traitors_car_sub TRUE
    SET_CAR_HEADING traitors_car_sub 72.0
    WARP_PLAYER_INTO_CAR player1 traitors_car_sub
    RESTORE_CAMERA_JUMPCUT
    SET_CAMERA_BEHIND_PLAYER

// Practice SCM removes much AI scripting and replaces with basic checks intended to keep the mission state similar to a live run
// BF has blip when player is on foot, and we reset if the BF blows up. Mission only passes when player drives BF to the end region
    // mission ending loop
    WHILE NOT LOCATE_PLAYER_ANY_MEANS_3D player1 34.9 1086.8 14.5 20.0 20.0 10.0 FALSE
    // OR NOT LOCATE_CHAR_ANY_MEANS_3D traitor 34.9 1086.8 14.5 15.0 15.0 10.0 FALSE
    OR NOT IS_PLAYER_IN_CAR player1 traitors_car_sub
        WAIT 0

            IF NOT IS_CAR_DEAD traitors_car_sub
                IF NOT IS_PLAYER_IN_CAR player1 traitors_car_sub
                AND flag_baron1_on_foot = 0
                    ADD_BLIP_FOR_CAR traitors_car_sub radar_blip_traitors_car
                    flag_baron1_on_foot = 1
                ENDIF

                IF IS_PLAYER_IN_CAR player1 traitors_car_sub
                AND flag_baron1_on_foot = 1
                    REMOVE_BLIP radar_blip_traitors_car
                    flag_baron1_on_foot = 0
                ENDIF

            ELSE // BF dead, let's reset
                EXPLODE_PLAYER_HEAD player1
                WAIT 5000
            ENDIF

    ENDWHILE

    SET_PLAYER_CONTROL player1 OFF

    // Practice SCM mission end - spawn guy for cs, and give him gun for aesthetic parity
    CREATE_CHAR PEDTYPE_CIVMALE SGa 85.977234 1111.829102 18.759708 traitor_sub
    GIVE_WEAPON_TO_CHAR traitor_sub WEAPONTYPE_RUGER 500

    WAIT 0

    SWITCH_WIDESCREEN ON

    IF NOT IS_CHAR_DEAD	traitor_sub
        IF IS_CHAR_IN_ANY_CAR traitor_sub
            WARP_CHAR_FROM_CAR_TO_COORD traitor_sub 56.4 1081.1 15.0		
        ENDIF

        DETACH_CHAR_FROM_CAR traitor_sub
        CLEAR_CHAR_THREAT_SEARCH traitor_sub
        SET_CHAR_OBJ_NO_OBJ traitor_sub
        SET_CHAR_COORDINATES traitor_sub 56.4 1081.1 15.0 
        SET_CHAR_HEADING traitor_sub 275.0  
        SET_CHAR_OBJ_RUN_TO_COORD traitor_sub 72.4 1082.8
        SET_CHAR_USE_PEDNODE_SEEK traitor_sub FALSE
    ENDIF

    SET_FIXED_CAMERA_POSITION 79.834 1069.695 14.212 0.0 0.0 0.0 
    POINT_CAMERA_AT_POINT 79.273 1070.427 14.597 JUMP_CUT

    WAIT 3000

    DELETE_CHAR traitor_sub

    SET_PLAYER_CONTROL player1 ON
    SWITCH_WIDESCREEN OFF
    RESTORE_CAMERA_JUMPCUT
    PLAY_MISSION_PASSED_TUNE 1
    PRINT_WITH_NUMBER_BIG ( M_PASS ) 1000 5000 1 //"Mission Passed!"
    CLEAR_WANTED_LEVEL player1
    ADD_SCORE player1 1000 

    // Practice SCM delay to practice bridge driving
    WAIT 8000

    // Practice SCM subroutine cleanup
    WARP_PLAYER_FROM_CAR_TO_COORD player1 -1155.529053 -1275.438477 14.813583
    DELETE_CAR traitors_car_sub
    DELETE_OBJECT temp_roadblock
    REMOVE_BLIP radar_blip_traitors_car
    SET_PLAYER_HEADING player1 180.0
    RESTORE_CAMERA_JUMPCUT
    SET_CAMERA_BEHIND_PLAYER
    RETURN