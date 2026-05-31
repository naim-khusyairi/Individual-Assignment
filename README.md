# Individual-Assignment
Individual Assignment - Muhammad Naim Khusyairi Bin Jaafar CDCS266 5A


  SMART PETROL COST CALCULATOR (Individual Assignment)
  README
MUHAMMAD NAIM KHUSYAIRI BIN JAAFAR
2024757865
CDCS266 5A
========================================================

  PROJECT OVERVIEW
--------------------------------------------------------
Smart Petrol Cost Calculator is an Android mobile
application that helps Malaysian users calculate their
petrol expenses based on fuel type, price per litre,
and fuel usage. It also supports the BUDI MADANI
government rebate scheme for eligible RON95 users.

  FEATURES
--------------------------------------------------------
- Select petrol type: RON95, RON97, or Diesel
- Enter petrol price per litre (RM)
- Enter fuel usage in litres
- BUDI MADANI rebate calculation (RON95 only)
- Displays:
    * Total Petrol Cost
    * BUDI MADANI Rebate (if eligible)
    * Total Payment Amount (after rebate)
    * Final Amount Payable
- Reset button to clear all inputs
- About screen with app information
- Clean, green-themed Material UI

  BUDI MADANI REBATE LOGIC
--------------------------------------------------------
- Applies ONLY to RON95 petrol type
- Rebate rate: RM 1.99 per litre
- Formula:
    Total Cost       = Usage (L) x Price per Litre
    BUDI Rebate      = Usage (L) x RM 1.99
    Payment Amount   = Total Cost - BUDI Rebate
- If user selects Yes but chooses RON97 or Diesel,
  a toast message will notify that the rebate only
  applies to RON95.

  HOW TO RUN
--------------------------------------------------------
1. Open Android Studio
2. Select "Open" and choose the PetrolCalc folder
3. Wait for Gradle sync to complete
4. Open Device Manager and start an emulator
   (wait for the home screen to fully load)
   OR connect a physical Android device via USB
   with USB Debugging enabled
5. Click the Run (▶) button

  NOTE: Ensure the emulator is fully booted before
  running the app to avoid installation errors.

  HOW TO USE THE APP
--------------------------------------------------------
1. Select your petrol type from the dropdown
   (RON95 / RON97 / Diesel)
2. Enter the petrol price per litre in RM
3. Enter your fuel usage in litres
4. Select "Yes" or "No" for BUDI MADANI eligibility
5. Tap CALCULATE to view results
6. Tap RESET to clear all fields and start again

========================================================
  END OF README
========================================================
