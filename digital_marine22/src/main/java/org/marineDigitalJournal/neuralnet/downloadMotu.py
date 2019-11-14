import pandas
import os
import platform
import subprocess
import datetime
from datetime import timedelta

cmd = ''

todayDT = datetime.datetime.now()

previousDT = (todayDT-(datetime.timedelta(days=4))).strftime("%Y-%m-%d 00:00:00")
posteriorDT=(todayDT-(datetime.timedelta(days=3))).strftime("%Y-%m-%d 00:00:00")


print(subprocess.call("python -m motuclient --motu http://nrt.cmems-du.eu/motu-web/Motu  --service-id OCEANCOLOUR_ATL_CHL_L4_NRT_OBSERVATIONS_009_037-TDS --product-id dataset-oc-atl-chl-multi-l4-oi_1km_daily-rt-v02 --longitude-min -45.99479293823242 --longitude-max 12.994793891906738 --latitude-min 20.005207061767578 --latitude-max 65.99478912353516 --date-min "+str(previousDT)+" --date-max "+str(posteriorDT)+" --variable CHL --variable CHL_error -o . --out-dir /application/pi/eclipse-workspace/blueMaritimeDigitalJournal/src/main/java/org/marineDigitalJournal/neuralnet/data/colour/currentData --user=IDura --pwd=e301Isaac* --verbose", shell=True))