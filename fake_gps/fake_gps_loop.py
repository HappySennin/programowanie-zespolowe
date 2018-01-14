import sys
import time
import requests
import json

COLOR = "\u001B[34m"
RESET = "\u001B[0m"


def log(message):
    print("{}{}{}".format(COLOR, message, RESET))


class Location:
    def __init__(self, latitude, longitude):
        self.latitude = latitude
        self.longitude = longitude

    def get_latitude(self):
        return self.latitude

    def get_longitude(self):
        return self.longitude

    def __str__(self):
        return "latitude: {} longitude: {}".format(self.get_latitude(), self.get_longitude())


def read_data_from_file():
    log("reading data from file...")
    cars_and_their_locations = {}
    with open('dataPetla', 'r') as data:
        for line in data:
            readed_line = line.split()
            current_car_id = int(readed_line[0])
            current_latitude = float(readed_line[1])
            current_longitude = float(readed_line[2])

            if current_car_id in cars_and_their_locations.keys():
                cars_and_their_locations[current_car_id].append(Location(current_latitude, current_longitude))
            else:
                cars_and_their_locations[current_car_id] = []
                cars_and_their_locations[current_car_id].append(Location(current_latitude, current_longitude))

    return cars_and_their_locations


def send_update_request(bearer_token, car_id, new_location):
    log("sending update request for car id: {} new location: {}".format(car_id, new_location))
    headers = {"Authorization": bearer_token, "Content-Type": "application/json"}
    payload = {"id": car_id, "latitude": new_location.get_latitude(), "longitude": new_location.get_longitude()}
    request_url = "http://localhost:8080/cars/location/update"

    print(requests.post(request_url, json=payload, headers=headers))


def login_and_get_token():
    log("logging to server...")
    login_url = "http://localhost:8080/login"
    login = "gps_module"
    password = "gps_module"
    response = requests.post(login_url, json={"login": login, "password": password})
    bearer_token = response.headers["Authorization"]

    return bearer_token


def main():
    cars_and_locations = read_data_from_file()
    sleep_time = int(sys.argv[1])
    bearer_token = login_and_get_token()
    counter = 0

    while True:
        log("{} iteration".format(counter))
        for car_id in cars_and_locations.keys():
            send_update_request(bearer_token, car_id, cars_and_locations[car_id][counter%len(cars_and_locations[car_id])])
        counter += 1
        time.sleep(sleep_time)


main()
