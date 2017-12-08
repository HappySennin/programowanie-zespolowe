export default {
  'luxuryCars': (state) => state.cars.luxury,
  'sedanCars': (state) => state.cars.sedan,
  'sportCars': (state) => state.cars.sportCar,
  'suvCars': (state) => state.cars.suv,
  'truckCars': (state) => state.cars.truck,
  'vanCars': (state) => state.cars.van,
  'carTypes': (state) => Object.keys(state.cars)
}
