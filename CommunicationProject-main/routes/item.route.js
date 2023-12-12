const express = require("express");
const itemExpressRoute = express.Router();
let ItemSchema = require("../models/item.model");

// Get Remaining Days
itemExpressRoute.route("/getRemainingDays/:idBook").put(async (req, res, next) => {
  try {
    let item = await ItemSchema.findOne({ idBook: req.params.idBook });

    if (!item) {
      item = await ItemSchema.create({ idBook: req.params.idBook });
    }

    let dateFin = "";

    try {
      const response = await fetch(`http://localhost:8081/ORDER/getDateFinByIdBook/${req.params.idBook}`);
      
      if (!response.ok) {
        throw new Error("Network response was not ok");
      }

      const data = await response.json();
      dateFin = data;
    } catch (error) {
      console.error("Error:", error);
    }
    const updatedItem = {
      _id: item._id,
      idBook: req.params.idBook,
      daysRemaining: Math.floor(
        (new Date(dateFin.toString()).getTime() - new Date().getTime()) /
          (1000 * 60 * 60 * 24)+1
      ),
    };

    if (updatedItem.daysRemaining < 0) {
      await ItemSchema.findByIdAndDelete(item._id);
      res.json({ msg: "This Book is Available." });
    } else {
      await ItemSchema.findByIdAndUpdate(item._id, { $set: updatedItem });
      res.json(updatedItem);
    }
  } catch (err) {
    return next(err);
  }
});


itemExpressRoute.route("/getAll").get(async (req, res, next) => {
  try {
    const items = await ItemSchema.find();
    res.json(items);
  } catch (err) {
    return next(err);
  }
});

module.exports = itemExpressRoute;
